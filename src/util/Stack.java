package util;

public class Stack<T> {

    // Define las variables de la clase "Stack"
    private NodeDouble<T> top; // El nodo superior de la pila
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    // Agrega un elemento colocándolo como nuevo nodo superior
    public void push(T data) {
        NodeDouble<T> newNode = new NodeDouble<>(data,size);
        newNode.setPrev(top);
        top = newNode;
        size++;
    }

    // Borra y retorna el último elemento aparte de que disminuye el tamaño
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T temp = top.getContent();
        top = (NodeDouble<T>) top.getPrev();
        size--;
        return temp;
    }

    // Retorna el elemento en la cima de la pila sin eliminarlo
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return top.getContent();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}
