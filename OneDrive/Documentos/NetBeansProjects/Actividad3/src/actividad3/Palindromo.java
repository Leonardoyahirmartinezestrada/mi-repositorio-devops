/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad3;

/**
 *
 * @author Leo_1
 */
public class Palindromo {
    public static boolean esPalindromo(int numero) {
        String numStr = Integer.toString(numero);
        return esPalindromoRec(numStr, 0, numStr.length() - 1);
    }

    private static boolean esPalindromoRec(String numStr, int inicio, int fin) {
        if (inicio >= fin) {
            return true;
        }
        if (numStr.charAt(inicio) != numStr.charAt(fin)) {
            return false;
        }
        return esPalindromoRec(numStr, inicio + 1, fin - 1);
    }
}

