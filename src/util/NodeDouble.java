package util;

public class NodeDouble<T> extends NodeSingle<T>{

    private NodeDouble<T> prev;
    /**
     * constructor
     *
     * @param c es un objeto, el contenido del nodo
     */
    public NodeDouble(T c, int id) {
        super(c,id);
    }

    public NodeSingle<T> getPrev() {
        return prev;
    }

    public void setPrev(NodeDouble<T> prev) {
        this.prev = prev;
    }


}
