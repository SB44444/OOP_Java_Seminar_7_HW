package notebook.view.mapper;

public interface Mapper<E, T> {
    E toInput(T t);

    T toOutput(E e);
}
