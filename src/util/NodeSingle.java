package util;

public class NodeSingle<T> implements Node<T> {

    private T content;
    /**
     * referencia para enlazar el siguiente
     */
    private int id;
    private NodeSingle<T> next;


    /**
     * constructor
     * @param c es un objeto, el contenido del nodo
     */

    public NodeSingle(T c, int id) {
        content= c;
        next = null;
        this.id=id;
    }


    @Override
    public T getContent() {
        return content;
    }


    @Override
    public void setContent(T p) {
        content = p;
    }


    public NodeSingle<T> getNext() {
        return next;
    }


    public void setNext(Node<T> siguiente) {
        this.next = (NodeSingle<T>) siguiente;
    }

    @Override
    public String toString() {
        return content.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean hasNext(){

        if(next.getContent()!=null)
            return true;

        return false;

    }
}