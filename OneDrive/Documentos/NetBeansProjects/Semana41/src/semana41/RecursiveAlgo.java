/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana41;

/**
 *
 * @author Leo_1
 */
public class RecursiveAlgo {
    int Queens = 4;
    
    void printTablero(int tablero[][]){
        for (int i = 0; i<Queens; i++){
            for (int j = 0; j<Queens; j++){
                if (tablero[i][j] == 1){
                    System.out.print("R ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public boolean isValid(int tablero[][], int row, int col){
        int i, j;
        
        for (i = 0; i < Queens; i++){
            if(tablero[row][i] == 1){
                return false;
            }
        }
        
        for(i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(tablero[i][j] == 1){
                return false;
            }
        }
        
        for(i = row, j = col; i < Queens && j >= 0; i++, j--) {
            if(tablero[i][j] == 1){
                return false;
            }
        }
        
        return true;
    }
    
    
    public boolean solveQueens(int tablero[][], int col){
        if (col >= Queens){
            return true;
        }
        
        for (int i = 0; i < Queens; i++){
            
            printTablero(tablero);
            if(isValid(tablero, i, col)) {
                tablero[i][col] = 1;
                
                if (solveQueens(tablero, col+1)) {
                    return true;
                }
                
                tablero[i][col] = 0;
            }
        }
        return false;
    }
    
    
    public boolean nQueens (int n ) {
        n = 0;
        
        int tablero [][]  = { {0, 0, 0, 0}, 
                            {0, 0, 0, 0},
                            {0, 0, 0, 0},
                            {0, 0, 0, 0}};
        if (solveQueens(tablero, n)) {
            System.out.println("Sí se puede");
            printTablero(tablero);
            return true;
        } else {
            System.out.println("No se puede");
            printTablero(tablero);
            return false;
        }
    }
}
