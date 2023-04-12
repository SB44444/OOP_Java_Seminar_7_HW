package notebook.util;

import notebook.controller.AbsController;
import notebook.controller.impl.UserController;
import notebook.model.User;
import notebook.model.repository.Operation;
import notebook.model.repository.impl.UserRepository;
import notebook.util.connector.Connector;
import notebook.util.connector.impl.FileDBConnector;
import notebook.view.AbsView;
import notebook.view.impl.UserView;

public class AvtoRun {
    private Connector connector;
    private Operation<User> repository;
    private AbsController<User> controller;
    private AbsView<User> view;

    public AvtoRun() {
        this.connector = new FileDBConnector();
        this.repository = new UserRepository(connector);
        this.controller = new UserController(repository);
        this.view = new UserView(controller);
    }

    public void run() {
        connector.connect();
        view.run();
    }
}
