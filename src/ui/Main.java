package ui;

import model.Controller;
import java.util.Scanner;

public class Main {

    private Scanner sc;

    public Main() {
        sc = new Scanner(System.in);
        new Controller();
    }

    public static void main(String[] args) {
        Main obPpal = new Main();
        int option = 0;

        do {
            option = obPpal.showMenuAndGetOption();
            obPpal.answerOption(option);
        } while (option != 0);

    // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }

    }

    public void answerOption(int userOption) {
        switch (userOption) {
            case 0:
                System.out.println("Cerrando la aplicación, bye");
                break;
            case 1:
                // Llamar a la función para agregar una nueva tarea
                ;
                break;
            case 2:
                // Llamar a la función para ver la lista de tareas
                ;
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
                "(1) Agregar nueva tarea\n" +
                "(2) Ver lista de tareas\n" +
                "(3) Eliminar tarea\n" +
                "(4) Marcar tarea como completada\n" +
                "(5) Deshacer última acción\n" +
                "(0) Salir\n");
        input = sc.nextInt();
        sc.nextLine();
        return input;
    }
}