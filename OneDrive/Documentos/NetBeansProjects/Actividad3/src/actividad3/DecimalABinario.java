/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad3;

/**
 *
 * @author Leo_1
 */
public class DecimalABinario {
    public static String convertirABinario(int numero) {
        if (numero == 0) {
            return "0";
        }
        return convertirABinarioRec(numero);
    }

    private static String convertirABinarioRec(int numero) {
        if (numero == 0) {
            return "";
        }
        return convertirABinarioRec(numero / 2) + (numero % 2);
    }
}

