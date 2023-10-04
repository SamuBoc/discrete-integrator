package util;

public class LinkedListRecursive<T> implements List<T>{

    private NodeDouble<T> first;
    private NodeDouble<T> last;
    private int numItems;



    public LinkedListRecursive() {

        numItems= 0;
    }

    @Override
    public boolean isEmpty() {

        return (first==null)&& (last ==null);

    }


    @Override
    public T search(T clave) {
        T content =null;

        if (!isEmpty())
            content = searchInSequence(first, clave);

        return content;
    }

    private T searchInSequence(Node<T> sq, T clave) {
        T found = null;

        if(sq!=null)
            if (sq.getContent().equals(clave))
                found = sq.getContent();
            else
                found= searchInSequence(sq.getNext(), clave);

        return found;
    }

    public T getObject(T clave) {
        T content =null;

        if (!isEmpty())
            content = getObjectInSequence(first, clave);

        return content;
    }

    private T getObjectInSequence(Node<T> sq, T clave) {
        T found = null;

        if(sq!=null)
            if (sq.getContent().equals(clave))
                found = sq.getContent();
            else
                found= getObjectInSequence(sq.getNext(), clave);

        return found;
    }




    @Override
    public void delete(Object clave) {
        // TODO Auto-generated method stub

    }

    public String print(){
        String out="";
        if (isEmpty()){
            out+= "Nothing here!";
        }
        else{
            out+= printSequence(first);
        }

        return out ;
    }

    private String printSequence(Node<T> node) {
        String out="";

        if (node==null) {
            out= "";
        }else
            out = node.getContent() + "\n"+printSequence(node.getNext());

        return out;
    }

    public String printBoard(){
        String out="";
        if (isEmpty()){
            out+= "empty";
        }
        else{
            out+= printBoardSequence(first,0);
        }

        return out ;
    }

    private String printBoardSequence(Node<T> node,Object i) {
        String out="";
        if (node==null) {
            out= "";
        }else{
            if((int)i%8==0){

                out = "\n"+node.getContent() + printBoardSequence(node.getNext(),(int)i+1);

            }else{
                out = node.getContent() + printBoardSequence(node.getNext(),(int)i+1);

            }
        }
        return out;
    }

    @Override
    public void addFirst(T n) {
        NodeDouble<T> newNode= new NodeDouble<>(n);

        if(first ==null) {// empty list
            first =newNode;
            last= newNode;
        } else {
            newNode.setNext(first);
            first.setPrev(newNode);
            first= newNode;
        }
        numItems++;

    }

    public Object getSize(){

        return numItems;

    }

    @Override
    public void addLast(T n) {
        NodeDouble<T> newNode= new NodeDouble<>(n);

        if(last ==null) {// empty list
            first =newNode;
            last= newNode;
        } else {
            newNode.setPrev(last);
            last.setNext(newNode);
            last= newNode;
        }
        numItems++;

    }

    public void changeContent(T clave, T newContent) {

        if (!isEmpty())
            changeContentInSequence(first, clave,newContent);

    }

    private void changeContentInSequence(Node<T> sq, T clave, T newContent) {


        if(sq!=null){
            if (sq.getContent().equals(clave)){
                sq.setContent(newContent);
            }
            else{

                changeContentInSequence(sq.getNext(), clave, newContent);
            }
        }
    }

}