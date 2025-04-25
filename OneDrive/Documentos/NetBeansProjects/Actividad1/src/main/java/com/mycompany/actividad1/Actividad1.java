/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad1;

import java.util.Scanner;

public class Actividad1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaSimplementeEnlazada<Object> listaSimplementeEnlazada = new ListaSimplementeEnlazada<>();
        Listadoblementeenlazada<Object> listadoblementeenlazada = new Listadoblementeenlazada<>();
        Listaenlazadacircular<Object> listaenlazadacircular = new Listaenlazadacircular<>();
        int option;

        do {
            System.out.println("Selecciona el tipo de lista enlazada:");
            System.out.println("1. Lista Simplemente Enlazada");
            System.out.println("2. Lista Doblemente Enlazada");
            System.out.println("3. Lista Circular");
            System.out.println("0. Salir");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    listOperationsSimple(listaSimplementeEnlazada, scanner);
                    break;
                case 2:
                    listOperationsDoubly(listadoblementeenlazada, scanner);
                    break;
                case 3:
                    listOperationsCircular(listaenlazadacircular, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void listOperationsSimple(ListaSimplementeEnlazada<Object> list, Scanner scanner) {
        int option;
        do {
            System.out.println("\nSelecciona una operación:");
            System.out.println("1. Insertar Elemento");
            System.out.println("2. Eliminar Elemento");
            System.out.println("3. Buscar Elemento");
            System.out.println("4. Imprimir Lista");
            System.out.println("0. Volver al menú principal");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el elemento: ");
                    Object element = scanner.next();
                    System.out.print("Ingrese la posición: ");
                    int pos = scanner.nextInt();
                    list.Insert(element, pos);
                    break;
                case 2:
                    System.out.print("Ingrese la posición del elemento a eliminar: ");
                    pos = scanner.nextInt();
                    list.Delete(pos);
                    break;
                case 3:
                    System.out.print("Ingrese el elemento a buscar: ");
                    Object elementToFind = scanner.next();
                    Node<Object> result = list.Find(elementToFind);
                    if (result != null) {
                        System.out.println("Elemento encontrado: " + result.data);
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;
                case 4:
                    list.Print();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 0);
    }

    private static void listOperationsDoubly(Listadoblementeenlazada<Object> list, Scanner scanner) {
        int option;
        do {
            System.out.println("\nSelecciona una operación:");
            System.out.println("1. Insertar Elemento");
            System.out.println("2. Eliminar Elemento");
            System.out.println("3. Buscar Elemento");
            System.out.println("4. Imprimir Lista");
            System.out.println("0. Volver al menú principal");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el elemento: ");
                    Object element = scanner.next();
                    System.out.print("Ingrese la posición: ");
                    int pos = scanner.nextInt();
                    list.Insert(element, pos);
                    break;
                case 2:
                    System.out.print("Ingrese la posición del elemento a eliminar: ");
                    pos = scanner.nextInt();
                    list.Delete(pos);
                    break;
                case 3:
                    System.out.print("Ingrese el elemento a buscar: ");
                    Object elementToFind = scanner.next();
                    Node<Object> result = (Node<Object>) list.Find(elementToFind);
                    if (result != null) {
                        System.out.println("Elemento encontrado: " + result.data);
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;
                case 4:
                    list.Print();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 0);
    }

    private static void listOperationsCircular(Listaenlazadacircular<Object> list, Scanner scanner) {
        int option;
        do {
            System.out.println("\nSelecciona una operación:");
            System.out.println("1. Insertar Elemento");
            System.out.println("2. Eliminar Elemento");
            System.out.println("3. Buscar Elemento");
            System.out.println("4. Imprimir Lista");
            System.out.println("0. Volver al menú principal");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el elemento: ");
                    Object element = scanner.next();
                    System.out.print("Ingrese la posición: ");
                    int pos = scanner.nextInt();
                    list.Insert(element, pos);
                    break;
                case 2:
                    System.out.print("Ingrese la posición del elemento a eliminar: ");
                    pos = scanner.nextInt();
                    list.Delete(pos);
                    break;
                case 3:
                    System.out.print("Ingrese el elemento a buscar: ");
                    Object elementToFind = scanner.next();
                    Node<Object> result = list.Find(elementToFind);
                    if (result != null) {
                        System.out.println("Elemento encontrado: " + result.data);
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;
                case 4:
                    list.Print();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 0);
    }
}






