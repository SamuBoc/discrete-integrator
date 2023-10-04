package util;

public interface Node<T> {

    T getContent();

    void setContent(T p);

    String toString();

    public NodeSingle<T> getNext();

    public void setNext(Node<T> siguiente);

}
