/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad3;

/**
 *
 * @author Leo_1
 */
public class Sudoku {
    private static final int TAMANO = 9;

    public static boolean resolverSudoku(int[][] tablero) {
        return resolverRec(tablero);
    }

    private static boolean resolverRec(int[][] tablero) {
        for (int fila = 0; fila < TAMANO; fila++) {
            for (int col = 0; col < TAMANO; col++) {
                if (tablero[fila][col] == 0) {
                    for (int num = 1; num <= TAMANO; num++) {
                        if (esSeguro(tablero, fila, col, num)) {
                            tablero[fila][col] = num;
                            if (resolverRec(tablero)) {
                                return true;
                            }
                            tablero[fila][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean esSeguro(int[][] tablero, int fila, int col, int num) {
        for (int x = 0; x < TAMANO; x++) {
            if (tablero[fila][x] == num || tablero[x][col] == num ||
                tablero[fila - fila % 3 + x / 3][col - col % 3 + x % 3] == num) {
                return false;
            }
        }
        return true;
    }
}

