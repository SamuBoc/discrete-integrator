package model;
import java.util.Calendar;
import java.util.GregorianCalendar;
import util.*;

public class Controller {

private HashTable<String,Item> itemHashTable;
private PriorityQueue<Item> itemPriorityQueueByPriority;
    private PriorityQueue<Item> itemPriorityQueueByDate;

    private Stack<Action> undoStack;


    public Controller(){

    undoStack = new Stack<>();
    itemHashTable = new HashTable<>();
    itemPriorityQueueByPriority = new PriorityQueue<>(new priorityCompare());
    itemPriorityQueueByDate = new PriorityQueue<>(new dateCompare());

}
    public void createItem(int type, String name, String description, int priority, int day, int month, int year) {
        // Create a GregorianCalendar object
        GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);

        // Create a new Item object with the given parameters
        Item item = new Item(name, description, priority, calendar, type, priority);

        itemHashTable.addElement(name,item);
        itemPriorityQueueByPriority.offer(item);
        itemPriorityQueueByDate.offer(item);

        createAction(0, item);

    }

    public String getItemsByDate(){
        PriorityQueue<Item> newDatePriorityQueue = new PriorityQueue<>(new dateCompare());
        Item currentItem;
        String out="The items organized by date are: ";
        while(!itemPriorityQueueByDate.isEmpty()){
            currentItem = itemPriorityQueueByDate.poll();
            out+="\n"+currentItem.toString();
            newDatePriorityQueue.offer(currentItem);

        }
        while(!newDatePriorityQueue.isEmpty()){

            itemPriorityQueueByDate.offer(newDatePriorityQueue.poll());

        }

        return out;

    }

    public String getItemsByPriority(){
        PriorityQueue<Item> newPriorityPriorityQueue = new PriorityQueue<>(new dateCompare());
        Item currentItem;
        String out="The items organized by priority are: ";
        while(!itemPriorityQueueByPriority.isEmpty()){
            currentItem = itemPriorityQueueByPriority.poll();
            out+="\n"+currentItem.toString();
            newPriorityPriorityQueue.offer(currentItem);

        }
        while(!newPriorityPriorityQueue.isEmpty()){

            itemPriorityQueueByPriority.offer(newPriorityPriorityQueue.poll());

        }

        return out;

    }

    public String viewListDate(){

    String out = "";

    for(int i = 0; i < itemPriorityQueueByDate.size(); i++){

    }

    return out;
    }


    public void createAction(int type, Item item) {

        Action action = new Action(type, item);

        undoStack.push(action);

    }

    //llama los metodos perdinentes para la stack
    public void undo() {
        Action lastAction = undoStack.pop();
        Item item = lastAction.getItem();

        if (!undoStack.isEmpty()) {
            ActionType actionType = lastAction.getActionType();

            switch (actionType) {
                case ADD_TASK -> stackDelete(item);
                case MODIFY_TASK -> stackModify(item);
                case DELETE_TASK -> stackAdd(item);
            }
        }
    }

    //elimina el ultimo item agregado
    private void stackDelete(Item item) {

        int type = item.getTypeItem() == TypeItem.Homework ? 1 : 2;
        String name = item.getName();
        String description = item.getDescription();
        int priority = item.getPriorityNumeric();
        Calendar date = item.getDateLimit();
        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH) + 1; // Se suma 1 porque en Calendar enero es 0
        int year = date.get(Calendar.YEAR);

        createItem(type, name, description, priority, day, month, year);

    }

    //modifica el ultimo item que modifico
    private void stackModify(Item originalItem) {



    }

    //agrega el item, si la ultima accion fue eliminar
    private void stackAdd(Item item){



    }


    //verifica si el item existe
    public boolean itemExists(int s, int i){

        if(!itemHashTable.search(s,i).equals(null)){

            return true;

        }

        return false;
    }

    //elimina el item
    public void deleteItem(int hashPointer, int linekdListPointer){

        Item currentItem = itemHashTable.search(hashPointer,linekdListPointer);
        //FIXME Pense que ibas a crearle un enum de deleted a los Items, pero hiciste una clase Action que nose como funciona
        //FIXME Haría esto yo pero no sé cómo si no tiene un enum que yo pueda modificar
        //FIXME Con el modifyItem() tienes una idea de como lo puedes hacer, e implementas lo que creasete :D

    }

    public void modifyItem( String newName, String newDescription, int newDay, int newMonth, int newYear, int hashPointer, int linekdListPointer) {
        GregorianCalendar calendar = new GregorianCalendar(newYear, newMonth-1, newDay);
        Item currentItem = itemHashTable.search(hashPointer,linekdListPointer);
        currentItem.setName(newName);
        currentItem.setDescription(newDescription);
        currentItem.setDateLimit(calendar);
    }

    public String searchItemToString(int hashPointer, int linekdListPointer){

        return itemHashTable.search(hashPointer,linekdListPointer).toString();

    }

    public String showItems(){

        return itemHashTable.showTable();

    }


}