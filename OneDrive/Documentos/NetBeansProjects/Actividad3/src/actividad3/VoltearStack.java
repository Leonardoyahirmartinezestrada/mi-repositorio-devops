/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad3;
import java.util.Stack;

/**
 *
 * @author Leo_1
 */
public class VoltearStack {
    public static void voltear(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            voltear(stack);
            insertarAlFondo(stack, temp);
        }
    }

    private static void insertarAlFondo(Stack<Integer> stack, int elemento) {
        if (stack.isEmpty()) {
            stack.push(elemento);
        } else {
            int temp = stack.pop();
            insertarAlFondo(stack, elemento);
            stack.push(temp);
        }
    }
}
