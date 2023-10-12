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

    public String viewListDate(){

    String out = "";

    for(int i = 0; i < itemPriorityQueueByDate.size(); i++){

    }

    return out;
    }

    public void eliminateItem(int position){


        //createAction(2, item);
    }

    public void modifyItem(){
        //createAction(1, item);


    }


    public void createAction(int type, Item item) {

        Action action = new Action(type, item);

        undoStack.push(action);

    }

    public void undo() {
        Action lastAction = undoStack.pop();
        Item item = lastAction.getItem();

        if (!undoStack.isEmpty()) {
            ActionType actionType = lastAction.getActionType();

            switch (actionType) {
                case ADD_TASK -> stackDelet(item);
                case MODIFY_TASK -> stackModify(item);
                case DELETE_TASK -> stackAdd(item);
            }
        }
    }

    private void stackDelet(Item item) {

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

    private void stackModify(Item originalItem) {



    }

    private void stackAdd(Item item){



    }


}