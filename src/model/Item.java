package model;

import java.sql.Date;

public class Item {
    
    private String name;
    private String description;
    private int priority;
    private Date dateLimit;
    private TypeItem typeItem;

    public Item(String name, String description, int priority, Date dateLimit, int typeItem){

        this.name = name;
        this.description = description;
        this.dateLimit = dateLimit;
        this.priority = priority;

        //diferenciador del tipo "tarea(1)" y "recordatorio(2)"
        if(typeItem == 1){
            this.typeItem = TypeItem.Homework;
        }else{
            this.typeItem = TypeItem.reminder;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public int getPriority() {
        return priority;
    }


    public void setPriority(int priority) {
        this.priority = priority;
    }


    public Date getDateLimit() {
        return dateLimit;
    }


    public void setDateLimit(Date dateLimit) {
        this.dateLimit = dateLimit;
    }


    public TypeItem getTypeItem() {
        return typeItem;
    }


    public void setTypeItem(TypeItem typeItem) {
        this.typeItem = typeItem;
    }


    

}
