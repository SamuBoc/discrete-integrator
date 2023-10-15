package ui;

import model.Controller;
import java.util.Scanner;

public class Main {

    private Scanner sc;
    private Controller co;

    public Main() {
        sc = new Scanner(System.in);
        co = new Controller();
    }

    public static void main(String[] args) {

        Main obPpal = new Main();
        int option = 0;

        do {
            option = obPpal.showMenuAndGetOption();
            obPpal.answerOption(option);
        } while (option != 0);

        System.out.printf("Hello and welcome!");

    }

    public void answerOption(int userOption) {
        switch (userOption) {
            case 0:
                System.out.println("Cerrando la aplicación, bye");
                break;
            case 1:
                // Llamar a la función para agregar una nueva tarea
                addNewTask();
                ;
                break;
            case 2:
                // Llamar a la función para ver la lista de tareas
                showMenuViewList();
                break;
            case 3:
                // Llamar a la función para eliminar una tarea
                deleteTask();
                ;
                break;
            case 4:
                // Llamar a la función para marcar una tarea como completada
                completeItem();
                ;
                break;
            case 5:
                // Llamar a la función para deshacer la última acción
                undoAction();
                ;
                break;
            case 6:
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public int showMenuAndGetOption() {
        int input;
        System.out.println("Sistema de gestión de tareas y recordatorios\n");
        System.out.println("Bienvenido\n");
        System.out.println("\n\nMenú de la aplicación, digite una opción\n" +
                        "(1) Agregar nuevo item \n" +
                        "(2) Ver lista \n" +
                        "(3) Eliminar item \n" +
                        "(4) Marcar item como completada \n" +
                        "(5) Deshacer última acció \n" +
                        "(6) Modificar tarea \n" +
                        "(0)Sali");
        input = sc.nextInt();
        sc.nextLine();
        return input;
    }

    public void showMenuViewList() {
        int input;
        boolean flag = false;
        do {
            System.out.println("\nMenu de muestras de listas\n" +
                    "(1) Ver lista por fecha (Ascendente)\n" +
                    "(2) Ver lista por nivel de prioridad \n" +
                    "(3) Ver lista por subdivisiones \n" +
                    "(0)Salir");
            input = sc.nextInt();
            sc.nextLine();

            switch (input){
                case 1:
                    System.out.println(viewListDate());
                    flag = true;
                    break;
                case 2:
                    System.out.println(viewListPriority());
                    flag = true;
                    break;
                case 3:
                    System.out.println(showItems());
                    flag = true;
                    break;
                case 0:
                    System.out.println("Volvera al menu principal \n");
                    flag = true;
                    break;
            }

        } while (!flag);
    }

    public void addNewTask() {

        // Clear the console
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n");
    
        // Prompt the user to select the type of item
        System.out.println("Select the type of item: \n 1. Task \n 2. Reminder");
    
        // Get the user's selection
        int type = sc.nextInt();
        sc.nextLine();
    
        // Prompt the user to enter the name of the item
        System.out.println("\n Enter the name of the ");
        String name = sc.nextLine();
    
        // Prompt the user to enter the description of the item
        System.out.println("\n Enter the description of the ");
        String description = sc.nextLine();
    
        // Prompt the user to enter the priority of the item
        System.out.println("\n enter the priority");
        int priority = sc.nextInt();
    
        sc.nextLine();
        System.out.println("below you will type the date \n");
    
        // Prompt the user to enter the day of the due date
        System.out.println("first enter the day");
        int day = sc.nextInt();
    
        sc.nextLine();
        System.out.println("\n now the month ");
        int month = sc.nextInt();
    
        sc.nextLine();
        System.out.println("\nlast enter the year");
        int year = sc.nextInt();
    
        // Create the new item using the `co.createItem()` method
        co.createItem(type, name, description, priority, day, month, year);
    
        // Display a success message to the user
        System.out.println("Your item has been successfully created!");
    
    }
    
    public String viewListDate(){
        String out = "";

        out=co.getItemsByDate();

        return out;
    }

    public String viewListPriority(){
        String out = "";

        out=co.getItemsByPriority();

        return out;
    }

    public String showItems(){

        String out = "";

        out=co.showItems();

        return out;

    }

    public void editTask() {

        System.out.println(showItems());
        System.out.println("Ingrese el numero de subdivisión");
        int subDivision= sc.nextInt();
        System.out.println("Ingrese el numero de la lista de la subdivisión que escojió");
        int num= sc.nextInt();



        // Verificar si el elemento existe en el hashTable antes de editarlo
        if (co.itemExists(subDivision,num)) {
            System.out.println("Ingrese el nuevo nombre: ");
            String newName = sc.nextLine();

            System.out.println("Ingrese la nueva descripción: ");
            String newDescription = sc.nextLine();



            System.out.println("Ingrese la nueva fecha de vencimiento (día): ");
            int newDay = sc.nextInt();
            sc.nextLine();

            System.out.println("Ingrese la nueva fecha de vencimiento (mes): ");
            int newMonth = sc.nextInt();
            sc.nextLine();

            System.out.println("Ingrese la nueva fecha de vencimiento (año): ");
            int newYear = sc.nextInt();
            sc.nextLine();

            co.modifyItem(newName, newDescription, newDay, newMonth, newYear,subDivision,num);
            System.out.println("Elemento editado exitosamente.");
        } else {
            System.out.println("El elemento no existe.");
        }
    }

    public void completeItem() {
        System.out.println(showItems());
        System.out.println("Ingrese el numero de subdivisión");
        int subDivision= sc.nextInt();
        System.out.println("Ingrese el numero de la lista de la subdivisión que escojió");
        int num= sc.nextInt();

        sc.nextLine();

        // Verificar si el elemento existe en el hashTable antes de eliminarlo
        if (co.itemExists(subDivision,num)) {
            co.deleteItem(subDivision,num);
            System.out.println("Elemento terminado con exitosamente.");
        } else {
            System.out.println("El elemento no existe.");
        }
    }

    public void deleteTask() {
        System.out.println(showItems());
        System.out.println("Ingrese el numero de subdivisión");
        int subDivision= sc.nextInt();
        System.out.println("Ingrese el numero de la lista de la subdivisión que escojió");
        int num= sc.nextInt();

        sc.nextLine();

        // Verificar si el elemento existe en el hashTable antes de eliminarlo
        if (co.itemExists(subDivision,num)) {
            co.deleteItem(subDivision,num);
            System.out.println("Elemento eliminado exitosamente.");
        } else {
            System.out.println("El elemento no existe.");
        }
    }

    public void undoAction(){

        System.out.println("\n");

        if(co.undo()){
            System.out.println("Su accion fue deshecha con exito \n");
        }else{
            System.out.println("No tiene ninguna accion para deshacer \n");
        }

    }

}