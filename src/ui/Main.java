package ui;

import model.Controller;
import java.util.Scanner;

public class Main {

    private Scanner sc;
    private Controller co;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

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
                ;
                break;
            case 4:
                // Llamar a la función para marcar una tarea como completada
                ;
                break;
            case 5:
                // Llamar a la función para deshacer la última acción
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
                        "(3) Eliminar item" +
                        "(4) Marcar item como completada" +
                        "(5) Deshacer última acció" +
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
                    "(2) Ver lista por nivel de prioridad \n \n" +
                    "(0)Sali");
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


        return out;
    }

    public String viewListPriority(){
        String out = "";



        return out;
    }



}