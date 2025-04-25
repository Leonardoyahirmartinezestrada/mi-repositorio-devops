/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad2;

import java.util.ArrayList;

public class Pila<E> {
    private ArrayList<E> lista = new ArrayList<>();

    // Método para agregar un elemento a la pila
    public void push(E element) {
        lista.add(element); // Añadir al final de la lista
    }

    // Método para eliminar y devolver el elemento en la parte superior de la pila
    public E pop() {
        if (!isEmpty()) {
            return lista.remove(lista.size() - 1); // Eliminar y devolver el último elemento
        }
        return null;
    }

    // Método para devolver el elemento en la parte superior de la pila sin eliminarlo
    public E peek() {
        if (!isEmpty()) {
            return lista.get(lista.size() - 1); // Obtener el último elemento
        }
        return null;
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    // Método para imprimir los elementos de la pila
    public void print() {
        for (E element : lista) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}







