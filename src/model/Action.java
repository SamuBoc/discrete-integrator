package model;

public class Action {
    public ActionType actionType;
    public Item item;
    public Item newItem;

    public Action(int actionType, Item item, Item newItem) {
        this.actionType = ActionType.values()[actionType];
        this.item = item;
        this.newItem = newItem;
    }

    public Item getNewItem() {
        return newItem;
    }

    public void setNewItem(Item newItem) {
        this.newItem = newItem;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public Item getItem() {
        return item;
    }

    public int ActionType(){
        return actionType.ordinal();
    }

}
