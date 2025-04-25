/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad2;

import java.util.ArrayList;

public class Cola<E> {
    private ArrayList<E> lista = new ArrayList<>();

    // Método para añadir un elemento a la cola
    public void enqueue(E element) {
        lista.add(element); // Añadir al final de la lista
    }

    // Método para eliminar y devolver el elemento en la parte delantera de la cola
    public E dequeue() {
        if (!isEmpty()) {
            return lista.remove(0); // Eliminar y devolver el primer elemento
        }
        return null;
    }

    // Método para devolver el elemento en la parte delantera de la cola sin eliminarlo
    public E peek() {
        if (!isEmpty()) {
            return lista.get(0); // Obtener el primer elemento
        }
        return null;
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    // Método para imprimir los elementos de la cola
    public void print() {
        for (E element : lista) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}



