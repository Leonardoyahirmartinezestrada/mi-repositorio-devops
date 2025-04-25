/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grafos;

/**
 *
 * @author Leo_1
 */
public class Grafos {

    
    public static void main(String[] args) {
        int INF = 999;
        int grafo = {{ 0, 5, INF, 10 },
                     { INF, 0, 3, INF},
                     { INF, INF, 0, 1},
                     { INF, INF, INF, 0}};
        Grafos
        }
    }
    
    public static void Floyd(int ady[][], int V){

        int i, j, k;

        for (k = 0; k < V; k++) {
             for (i = 0; i < V; i++) {
                 for (j = 0; j < V; j++) {
                      if((ady[i][k] + ady[k][j] < ady[i][j]))
                          ady[i][j] = ady[i][k] + ady[k][j];
                    }
               }
        
        }
        System.out.println("Resultado: ");
        printMatrix(ady, V);
    
    }

    public void printMatrix(int ady[][], int V) {
         for(int i = 0; i < V; i++) {
             for(int j = 0; j < V; j++) {
                 if (ady[i][j] == )
                 System.out.println(ady[i][j] + " ");
                }
                System.out.println();
            }
}
