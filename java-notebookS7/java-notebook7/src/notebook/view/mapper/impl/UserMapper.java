package notebook.view.mapper.impl;

import notebook.model.User;
import notebook.view.mapper.Mapper;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class UserMapper implements Mapper<User, String> {
    protected String parsingChar;

    public UserMapper(String parsingChar) {
        this.parsingChar = parsingChar;
        parsingChar = ", ";
    }

    @Override
    public User toInput(String s) {
        String[] lines = s.split(parsingChar);

        if (!isDigit(lines[0])) {
            throw new NumberFormatException("Id must be a large number");
        }

        if (!isDateTime(lines[4]) || !isDateTime(lines[5]))
            throw new DateTimeException("Date must be a time format");

        return new User(
                Long.parseLong(lines[0]), lines[1], lines[2], lines[3],
                LocalDateTime.parse(lines[4]), LocalDateTime.parse(lines[5]));
    }

    @Override
    public String toOutput(User outList) {
        return String.join(
                parsingChar,
                outList.getId().toString(),
                outList.getMyHeadline(),
                outList.getMyText(),
                outList.getMyComment(),
                outList.getPutDate().toString(),
                outList.getReDate().toString()
        );
    }

    private boolean isDigit(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDateTime(String s) {
        try {
            LocalDateTime.parse(s);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }
}
