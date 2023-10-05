package model;

public class Pilas<T> {

    // definition del node
    class Node {
        T elem;
        Node Next;

        public Node(T o) {
            elem = o;
            Next = null;
        }

        public T getElem() {
            return elem;
        }

        public void setElem(T elem) {
            this.elem = elem;
        }

        public Node getNext() {
            return Next;
        }

        public void setNext(Node next) {
            Next = next;
        }
    }

    // define las variables de la class "LinkedStack"
    Node end; // al ser un stack solo se puede ver la parte de arriba de la cola
    int size;

    public Pilas() {
        end = null;
        size = 0;
    }

    // agrega un elemento coloando este como nuevo final y concatenando (OBJETO
    // GENERICO)
    public void push(T k) {
        Node nodo = new Node(k);
        if (end == null) {
            end = nodo;
        } else {
            nodo.setNext(end);
            end = nodo;
        }
        size++;
    }

    // borra y retorna el ultimo elemento aparte de que disminuye el size
    public T pop() {
        if (end == null) {
            return null;
        }
        T temp = end.getElem();
        end = end.Next;
        size--;
        return temp;
    }

    public T peek() {
        if (end == null) {
            return null;
        }
        return end.getElem();
    }

    public boolean isEmpty() {
        boolean retorno = true;
        if (end == null) {
            retorno = false;
        }
        return retorno;
    }

    public int setSize() {
        return size;
    }

}
