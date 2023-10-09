package model;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;


public class Item {

    private String name;
    private String description;
    private int priorityNumeric;
    private Calendar dateLimit;
    private TypeItem typeItem;
    private PriorityLevel priorityLevel;

    public Item(String name, String description, int priorityNumeric, Calendar dateLimit, int typeItem, int priorityLevel) {

        this.name = name;
        this.description = description;
        this.dateLimit = dateLimit;
        this.priorityNumeric = priorityNumeric;

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


    public int getPriorityNumeric() {
        return priorityNumeric;
    }


    public void setPriorityNumeric(int priorityNumeric) {
        this.priorityNumeric = priorityNumeric;
    }

    public TypeItem getTypeItem() {
        return typeItem;
    }


    public void setTypeItem(TypeItem typeItem) {
        this.typeItem = typeItem;
    }



    //FIXME preguntar por ennum de prioridad
    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }
    public void setPriorityLevel(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
    //FIXME preguar por enum de prioridad

    public String getStringDateLimit() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
        return sdf.format(dateLimit.getTime());
    }

    public Calendar getDateLimit() {
        return dateLimit;
    }

    public void setDateLimit(Calendar dateLimit) {
        this.dateLimit = dateLimit;
    }

    @Override
    public String toString(){

        return name+"\n\n"+"Priority Level: "+priorityLevel+"\n\n"+description;

    }




    //priorityLevel.ordinal(); Retorna la posición del enum como en un arreglo...
    //Super valioso para cuando implementemos comparable...

}

class priorityCompare implements Comparator<Item> {
    public int compare(Item m1, Item m2)
    {
        if (m1.getPriorityLevel().ordinal() < m2.getPriorityLevel().ordinal())
            return -1;
        if (m1.getPriorityLevel().ordinal() > m2.getPriorityLevel().ordinal())
            return 1;
        else
            return 0;
    }
}

class dateCompare implements Comparator<Item> {
    public int compare(Item m1, Item m2)
    {
        if (m1.getDateLimit().compareTo(m2.getDateLimit())<0)
            return -1;
        if (m1.getDateLimit().compareTo(m2.getDateLimit())>0)
            return 1;
        else
            return 0;
    }
}