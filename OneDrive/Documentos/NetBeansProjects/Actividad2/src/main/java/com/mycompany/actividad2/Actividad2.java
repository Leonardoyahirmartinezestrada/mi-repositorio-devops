/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad2;

import java.time.LocalDate;
import java.util.Scanner;

public class Actividad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cola<Task> colaEjecucion = new Cola<>();
        Pila<Task> pilaComandos = new Pila<>();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear y añadir Task a la cola de ejecución");
            System.out.println("2. Mover Task de la cola de ejecución a la pila de comandos");
            System.out.println("3. Ver historial de comandos");
            System.out.println("4. Ejecutar y eliminar Task de la pila de comandos");
            System.out.println("5. Ver cola de ejecución");
            System.out.println("0. Salir");

            int option = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre del Task: ");
                    String nombre = scanner.nextLine();
                    Task newTask = new Task(nombre, LocalDate.now());
                    colaEjecucion.enqueue(newTask);
                    break;

                case 2:
                    if (!colaEjecucion.isEmpty()) {
                        Task taskToMove = colaEjecucion.dequeue();
                        pilaComandos.push(taskToMove);
                    } else {
                        System.out.println("La cola de ejecución está vacía.");
                    }
                    break;

                case 3:
                    System.out.println("Historial de comandos:");
                    pilaComandos.print();
                    break;

                case 4:
                    if (!pilaComandos.isEmpty()) {
                        Task executedTask = pilaComandos.pop();
                        System.out.println("Ejecutando y eliminando: " + executedTask);
                    } else {
                        System.out.println("No hay comandos en la pila.");
                    }
                    break;

                case 5:
                    System.out.println("Cola de ejecución:");
                    colaEjecucion.print();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    scanner.close(); // Cerrar el scanner
                    return;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}



