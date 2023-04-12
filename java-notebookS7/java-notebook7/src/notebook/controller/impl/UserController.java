package notebook.controller.impl;

import notebook.controller.AbsController;
import notebook.model.User;
import notebook.model.repository.Operation;

import java.util.Optional;

public class UserController extends AbsController<User> {
    public UserController(Operation<User> repository) {
        this.repository = repository;
    }

    @Override
    public User get(String id) throws RuntimeException {
        Optional<User> textID = repository.get(Long.parseLong(id));

        if (textID.isPresent()) return textID.get();

        throw new RuntimeException("ID not found");
    }

    @Override
    public void update(String id, User update) {
        try {
            repository.update(Long.parseLong(id), update);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
