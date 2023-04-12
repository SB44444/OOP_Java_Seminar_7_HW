package notebook.controller;

import notebook.model.repository.Operation;

import java.util.List;

public abstract class AbsController<T> {
    protected Operation<T> repository;

    public void create(T t) {
        repository.create(t);
    }

    public abstract T get(String id) throws Exception;

    public List<T> getAll() {
        return repository.getAll();
    }

    public abstract void update(String id, T update);

    public void delete(String id) {
        repository.delete(Long.parseLong(id));
    }
}
