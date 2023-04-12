package notebook.model.repository.impl;

import notebook.model.User;
import notebook.model.repository.Operation;
import notebook.util.connector.Connector;
import notebook.view.mapper.Mapper;
import notebook.view.mapper.impl.UserMapper;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements Operation<User> {
    private final Mapper<User, String> mapper;
    private final Connector connector;

    public UserRepository(Connector connector, String sep) {
        this.mapper = new UserMapper(sep);
        this.connector = connector;
    }

    public UserRepository(Connector connector) {
        this(connector, ", ");
    }

    @Override
    public User create(User note) {
        List<User> notes = getAll();
        long lastId = 0L;

        for (User n : notes) {
            long id = n.getId();
            if (lastId < id) lastId = id;
        }
        long nextId = lastId + 1;
        note.setId(nextId);
        notes.add(note);
        save(notes);
        return note;
    }

    @Override
    public List<User> getAll() {
        List<String> lines = new ArrayList<>();
        List<User> notes = new ArrayList<>();

        try {
            File file = new File(connector.uri);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            if (line != null) lines.add(line);
            while (line != null) {
                line = reader.readLine();
                if (line != null) lines.add(line);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : lines) notes.add(mapper.toInput(line));
        return notes;
    }

    @Override
    public Optional<User> get(Long id) {
        List<User> notes = getAll();

        for (User note : notes)
            if (note.getId().equals(id))
                return Optional.of(note);
        return Optional.empty();
    }

    @Override
    public Optional<User> update(Long id, User update) {
        List<User> notes = getAll();
        User noteToUpdate = notes.stream()
                .filter(n -> n.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Not found"));
        noteToUpdate.setMyHeadline(update.getMyHeadline());
        noteToUpdate.setMyText(update.getMyText());
        noteToUpdate.setMyComment(update.getMyComment());
        noteToUpdate.setReDate(LocalDateTime.now());
        save(notes);
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        List<User> notes = getAll();

        for (User note : notes) {
            if (note.getId().equals(id)) {
                notes.remove(note);
                save(notes);
                return true;
            }
        }
        return false;
    }
    @Override
    public void save(List<User> notes) {
        List<String> lines = new ArrayList<>();

        for (User note : notes) lines.add(mapper.toOutput(note));
        try (FileWriter writer = new FileWriter(connector.uri, false)) {
            for (String line : lines) writer.write(line + "\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
