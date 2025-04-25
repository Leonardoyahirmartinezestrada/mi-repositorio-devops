/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana4;
import java.util.Stack;
/**
 *
 * @author Leo_1
 */
public class RecursiveAlgo {
    
    public long fact (long num) {
        if (num <= 1) {
            return 1;
        }
        return num * fact(num -1);
    }
    
    public long fibo (long pos) {
        if (pos == 1) {
            return 0;
        }
        if (pos == 2 || pos == 3) {
            return 1;
        }
        return fibo(pos-1) + fibo(pos-2);
    }
    
    public int encontrarMax(int[] a, int lower, int upper) {
        if (lower > upper){
            return Integer.MIN_VALUE;
        }
        if (lower == upper) {
            return a[lower];
        }
        
        int mid = (lower + upper) / 2;
        
        int maxIzq = encontrarMax(a, lower, mid);
        int maxDer = encontrarMax(a, mid+1, upper);
        
        return Math.max(maxIzq, maxDer);
        
        
    }
    
 /*   public class NumMinRec {
        public static void main(String[] args) {
        int[] array = {3, 5, 7, 2, 8, 6, 4}; // Ejemplo de array

        // Encontrar el mínimo
        int min = encontrarMin(array, 0, array.length - 1);

        // Imprimir el resultado
        System.out.println("Número mínimo: " + min);
    }

    // Método recursivo para encontrar el número mínimo en el array
    public static int encontrarMin(int[] a, int lower, int upper) {
        // Caso base: cuando el rango es inválido
        if (lower > upper) {
            return Integer.MAX_VALUE; // Valor máximo posible para asegurar que no se elija
        }
        // Caso base: cuando el rango tiene un solo elemento
        if (lower == upper) {
            return a[lower];
        }
        
        // Dividir el rango en dos mitades
        int mid = (lower + upper) / 2;
        
        // Encontrar el mínimo en cada mitad
        int minIzq = encontrarMin(a, lower, mid);
        int minDer = encontrarMin(a, mid + 1, upper);
        
        // Retornar el mínimo de las dos mitades
        return Math.min(minIzq, minDer);
    
    }*/
    
    public void move(Stack origin, Stack destiny) {
        destiny.push(origin.pop());
    }
    
    public void hanoi(Stack origin, Stack destiny, Stack aux, int n) {
        if (n == 1) {
            move(origin, destiny);
            System.out.println(origin);
            System.out.println(destiny);
            System.out.println(aux);
            System.out.println();
        } else {
            hanoi(origin, aux, destiny, n-1);
            move(origin, destiny);
            System.out.println(origin);
            System.out.println(destiny);
            System.out.println(aux);
            System.out.println();
            hanoi(aux, destiny, origin, n-1);
        }
    }
    
    int QUEENS = 4;
    
    public boolean isValid(int tablero[][], int row, int col) {
        int i, j;
        
        for(i =0; i < QUEENS; i++) {
            if(tablero[row][i] == 1) {
                return false;
            }
        }
        
        for(i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(tablero[i][j] == 1) {
                return false;
            }
        }
        
        for(i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(tablero[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    
    void printTablero(int tablero[][]) {
        for (int i = 0; i < QUEENS; i++) {
            for (int j = 0; j < QUEENS; j++) {
                if (tablero[i][j] == 1) {
                    System.out.println("R ");
                } else {
                    System.out.println("_ ");
                }
            }
            
            System.out.println();
        }
        
        System.out.println();
    }
    
    public boolean solveQueens(int tablero[][], int col) {
        if (col >= QUEENS) {
            return true;
        }
        
        for (int i = 0; i < QUEENS; i++){
            
            printTablero(tablero);
            if(isValid(tablero, i, col)) {
                tablero[i][col] = 1;
                
                if (solveQueens(tablero, col+1)){
                    return true;
                }
                
                tablero[i][col] = 0;
            }
        }
        
        return false;
    }
    
    public boolean nQueens(int n) {
        n = 4;
        
        int [][] tablero = { {0,0,0,0},
                             {0,0,0,0},
                             {0,0,0,0},
                             {0,0,0,0}};
        
        if (solveQueens(tablero, n)) {
            System.out.println("Si se puede");
            printTablero(tablero);
            return true;
        } else {
            System.out.println("No se puede");
            printTablero(tablero);
            return false;
        }
    }
}