package util;
import org.junit.Test;
import static org.junit.Assert.*;


public class StackTest {

    @Test
    public void testPushAndPop() {
        // Crear una pila de tipo Integer
        Stack<Integer> stack = new Stack<>();

        // Añadir elementos a la pila
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Verificar que el tamaño de la pila sea el correcto
        assertEquals(3, stack.size());

        // Probar el método pop para eliminar elementos
        Integer poppedValue = stack.pop();
        assertEquals(Integer.valueOf(3), poppedValue);
        assertEquals(2, stack.size());

        // Pop los otros elementos y verifícalos
        poppedValue = stack.pop();
        assertEquals(Integer.valueOf(2), poppedValue);
        assertEquals(1, stack.size());

        poppedValue = stack.pop();
        assertEquals(Integer.valueOf(1), poppedValue);
        assertEquals(0, stack.size());

        // Verificar si la pila está vacía después de eliminar todos los elementos
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        // Crear una pila de tipo String
        Stack<String> stack = new Stack<>();

        // Añadir elementos a la pila
        stack.push("A");
        stack.push("B");

        // Verificar el método peek para obtener el elemento en la cima
        assertEquals("B", stack.peek());

        // Verificar que el tamaño de la pila no cambia después de peek
        assertEquals(2, stack.size());
    }

    @Test
    public void testPushAndPopMixedTypes() {
        Stack<Object> stack = new Stack<>();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        // Push elementos de diferentes tipos a la pila
        stack.push("A");
        stack.push(123);
        stack.push(3.14);

        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());

        // Pop y verifique los elementos
        assertEquals(3.14, stack.pop());
        assertEquals(123, stack.pop());
        assertEquals("A", stack.pop());

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }


}
