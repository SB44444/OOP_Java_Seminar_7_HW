package notebook.view.impl;

import notebook.controller.AbsController;
import notebook.model.User;
import notebook.util.Commands;
import notebook.view.AbsView;

import java.util.List;
import java.util.Scanner;

public class UserView extends AbsView<User> {
    public UserView(AbsController<User> controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        Commands com;

        while (true) {
            String command = prompt(
                    "Available command:\nEXIT - to exit\nCREATE - to write\nLIST - to view all\nGET - to find by ID \nUPDATE - to change\nDELETE - to dell\nInput command:  ");
            com = Commands.valueOf(command.toUpperCase());

            switch (com) {
                case CREATE -> {
                    User record = createUser();
                    controller.create(record);
                }

                case GET -> {
                    String id = prompt("Input ID: ");
                    try {
                        User record = controller.get(id);
                        System.out.println(record + "\n");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

                case LIST -> {
                    List<User> notes = controller.getAll();

                    System.out.println();

                    for (User record : notes) {
                        System.out.println(record);
                        System.out.println();
                    }
                }

                case UPDATE -> {
                    String id = prompt("Input ID: ");
                    controller.update(id, createUser());
                }

                case DELETE -> {
                    String id = prompt("Input ID: ");
                    controller.delete(id);
                }

                case EXIT -> {
                    System.out.println("Exit");
                    return;
                }
            }
        }
    }

    private String prompt(String scLine) {
        Scanner sc = new Scanner(System.in);
        System.out.print(scLine);
        return sc.nextLine();
    }

    private User createUser() {
        String MyHeadline = prompt("Headline: ");
        String myText = prompt("Text: ");
        String myComments = prompt("Comments: ");
        return new User(MyHeadline, myText, myComments);
    }
}
