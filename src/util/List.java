package util;

public interface List<T> {

    public boolean isEmpty();
    public void addFirst(T n);
    public void addLast(T n);
    public T search(T clave);
    public boolean delete(T clave);

}
