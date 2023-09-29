package ui;


import model.*;


public class Main {
    
    public static void main(String[] args) {
        Pilas<Usuario> pila = new Pilas<>();
        Usuario usuario1 = new Usuario("samuel", "calle 37", "3005314715");
        Usuario usuaroi2 = new Usuario("Valeria", "puetne", "0");


        pila.push(usuario1);
        System.out.println(((Usuario)pila.peek()).getNombre());
        pila.push(usuaroi2);
        System.out.println(((Usuario)pila.peek()).getNombre());
        pila.pop();
        System.out.println(" El objeto (" + ((Usuario)pila.pop()).getNombre() + ") fue eliminado de la lista");

        System.out.println("Por ende el elemento sobrante es (" + ((Usuario)pila.peek()).getNombre() + ")");

        
        //Pilas<String> pila = new Pilas<>();
        //pila.push("hola");
        //pila.push("total");
        //System.out.println(pila.peek());
        //pila.pop();
        //System.out.println(pila.peek());


    }
}