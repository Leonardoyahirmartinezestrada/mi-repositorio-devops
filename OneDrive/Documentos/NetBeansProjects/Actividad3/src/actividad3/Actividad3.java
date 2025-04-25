/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad3;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Leo_1
 */
public class Actividad3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1. Verificar si un número es palíndromo");
            System.out.println("2. Suma de subconjuntos");
            System.out.println("3. Resolver Sudoku");
            System.out.println("4. Voltear un Stack");
            System.out.println("5. Convertir Decimal a Binario");
            System.out.println("6. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el número:");
                    int numero = scanner.nextInt();
                    if (Palindromo.esPalindromo(numero)) {
                        System.out.println(numero + " es un palíndromo");
                    } else {
                        System.out.println(numero + " no es un palíndromo");
                    }
                    break;

                case 2:
                    System.out.println("Ingresa el tamaño del conjunto:");
                    int n = scanner.nextInt();
                    int[] nums = new int[n];
                    System.out.println("Ingresa los elementos del conjunto:");
                    for (int i = 0; i < n; i++) {
                        nums[i] = scanner.nextInt();
                    }
                    System.out.println("Ingresa el valor objetivo:");
                    int objetivo = scanner.nextInt();
                    if (SubsetSum.existeSubconjunto(nums, objetivo)) {
                        System.out.println("Existe un subconjunto cuya suma es " + objetivo);
                    } else {
                        System.out.println("No existe un subconjunto cuya suma sea " + objetivo);
                    }
                    break;

                case 3:
                    System.out.println("Resuelve el Sudoku:");
                    int[][] tablero = {
                        {5, 3, 0, 0, 7, 0, 0, 0, 0},
                        {6, 0, 0, 1, 9, 5, 0, 0, 0},
                        {0, 9, 8, 0, 0, 0, 0, 6, 0},
                        {8, 0, 0, 0, 6, 0, 0, 0, 3},
                        {4, 0, 0, 8, 0, 3, 0, 0, 1},
                        {7, 0, 0, 0, 2, 0, 0, 0, 6},
                        {0, 6, 0, 0, 0, 0, 2, 8, 0},
                        {0, 0, 0, 4, 1, 9, 0, 0, 5},
                        {0, 0, 0, 0, 8, 0, 0, 7, 9}
                    };
                    if (Sudoku.resolverSudoku(tablero)) {
                        System.out.println("Sudoku resuelto:");
                        for (int i = 0; i < 9; i++) {
                            for (int j = 0; j < 9; j++) {
                                System.out.print(tablero[i][j] + " ");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("No se pudo resolver el Sudoku.");
                    }
                    break;

                case 4:
                    Stack<Integer> stack = new Stack<>();
                    System.out.println("Ingresa los elementos del Stack (termina con -1):");
                    int elemento = scanner.nextInt();
                    while (elemento != -1) {
                        stack.push(elemento);
                        elemento = scanner.nextInt();
                    }
                    VoltearStack.voltear(stack);
                    System.out.println("Stack invertido:");
                    while (!stack.isEmpty()) {
                        System.out.println(stack.pop());
                    }
                    break;

                case 5:
                    System.out.println("Ingresa un número decimal:");
                    int decimal = scanner.nextInt();
                    System.out.println("El binario es: " + DecimalABinario.convertirABinario(decimal));
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 6);

        scanner.close();
    }
}