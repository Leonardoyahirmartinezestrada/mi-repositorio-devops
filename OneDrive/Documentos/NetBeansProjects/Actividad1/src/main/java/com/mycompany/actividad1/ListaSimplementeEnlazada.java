/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad1;

public class ListaSimplementeEnlazada<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    public ListaSimplementeEnlazada() {
        head = null;
        size = 0;
    }

    public void Insert(E element, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode = new Node<>(element);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public void Delete(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            head = head.next;
        } else {
            Node<E> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public Node<E> FindByPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void Print() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}




