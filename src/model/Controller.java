package model;
import java.util.GregorianCalendar;

public class Controller {

    public void createItem(int type, String name, String description, int priority, int day, int month, int year) {
        // Create a GregorianCalendar object
        GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);

        // Create a new Item object with the given parameters
        Item item = new Item(name, description, priority, calendar, type, priority);
    }



}