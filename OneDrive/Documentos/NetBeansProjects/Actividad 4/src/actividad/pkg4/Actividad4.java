/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg4;
import java.util.Scanner;

/**
 *
 * @author Leo_1
 */
public class Actividad4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // Insertar empleados en el árbol (puedes modificar la lista según sea necesario)
        int[] empleadosPredefinidos = {101, 110, 115, 108, 103};
        for (int id : empleadosPredefinidos) {
            arbol.insertar(id);
        }
        System.out.println("Empleados predefinidos insertados en el árbol.");

        while (opcion != 8) {
            System.out.println("\n--- Menú de Operaciones del Árbol Binario ---");
            System.out.println("1. Insertar empleado");
            System.out.println("2. Eliminar empleado");
            System.out.println("3. Buscar empleado");
            System.out.println("4. Mostrar recorrido inorden");
            System.out.println("5. Mostrar recorridos preorden, inorden y postorden");
            System.out.println("6. Comparar búsqueda en árbol con búsqueda secuencial");
            System.out.println("7. Mostrar recorrido inorden inicial");
            System.out.println("8. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del empleado a insertar: ");
                    int idInsertar = sc.nextInt();
                    arbol.insertar(idInsertar);
                    System.out.println("Empleado con ID " + idInsertar + " insertado.");
                    break;

                case 2:
                    System.out.print("Ingrese el ID del empleado a eliminar: ");
                    int idEliminar = sc.nextInt();
                    arbol.eliminar(idEliminar);
                    System.out.println("Empleado con ID " + idEliminar + " eliminado.");
                    break;

                case 3:
                    System.out.print("Ingrese el ID del empleado a buscar: ");
                    int idBuscar = sc.nextInt();
                    if (arbol.buscar(idBuscar)) {
                        System.out.println("Empleado con ID " + idBuscar + " encontrado.");
                    } else {
                        System.out.println("Empleado con ID " + idBuscar + " no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Recorrido inorden del árbol:");
                    arbol.inorden();
                    break;

                case 5:
                    System.out.println("Recorrido preorden del árbol:");
                    arbol.preorden();
                    System.out.println("Recorrido inorden del árbol:");
                    arbol.inorden();
                    System.out.println("Recorrido postorden del árbol:");
                    arbol.postorden();
                    break;

                case 6:
                    System.out.print("Ingrese el ID del empleado a buscar secuencialmente: ");
                    int idSecuencial = sc.nextInt();

                    long startTreeSearch = System.nanoTime();
                    boolean encontradoEnArbol = arbol.buscar(idSecuencial);
                    long endTreeSearch = System.nanoTime();
                    long tiempoArbol = endTreeSearch - startTreeSearch;

                    long startSequentialSearch = System.nanoTime();
                    boolean encontradoSecuencial = false;
                    for (int id : empleadosPredefinidos) {
                        if (id == idSecuencial) {
                            encontradoSecuencial = true;
                            break;
                        }
                    }
                    long endSequentialSearch = System.nanoTime();
                    long tiempoSecuencial = endSequentialSearch - startSequentialSearch;

                    System.out.println("\n--- Resultados de la Comparación ---");
                    if (encontradoEnArbol) {
                        System.out.println("Empleado con ID " + idSecuencial + " encontrado en el árbol binario.");
                    } else {
                        System.out.println("Empleado con ID " + idSecuencial + " no encontrado en el árbol binario.");
                    }

                    if (encontradoSecuencial) {
                        System.out.println("Empleado con ID " + idSecuencial + " encontrado en búsqueda secuencial.");
                    } else {
                        System.out.println("Empleado con ID " + idSecuencial + " no encontrado en búsqueda secuencial.");
                    }

                    System.out.println("Tiempo de búsqueda en árbol binario: " + tiempoArbol + " nanosegundos.");
                    System.out.println("Tiempo de búsqueda secuencial: " + tiempoSecuencial + " nanosegundos.");
                    break;

                case 7:
                    System.out.println("Recorrido inorden inicial del árbol:");
                    arbol.inorden();
                    break;

                case 8:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}