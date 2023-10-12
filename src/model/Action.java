package model;

public class Action {
    public ActionType actionType;
    public Item item;

    public Action(int actionType, Item item) {
        this.actionType = ActionType.values()[actionType];
        this.item = item;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public Item getItem() {
        return item;
    }
}
