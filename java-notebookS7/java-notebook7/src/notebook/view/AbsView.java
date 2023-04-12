package notebook.view;

import notebook.controller.AbsController;

public abstract class AbsView<U> {
    protected AbsController<U> controller;

    public abstract void run();
}
