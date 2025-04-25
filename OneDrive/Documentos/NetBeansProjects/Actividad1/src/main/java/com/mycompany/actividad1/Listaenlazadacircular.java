/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad1;

public class Listaenlazadacircular<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public Listaenlazadacircular() {
        head = null;
        tail = null;
        size = 0;
    }

    public void Insert(E element, int position) {
        Node<E> newNode = new Node<>(element);
        if (size == 0) {
            head = tail = newNode;
            tail.next = head;
        } else if (position == 0) {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        } else {
            Node<E> current = head;
            for (int i = 0; i < position - 1 && current.next != head; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            if (current == tail) {
                tail = newNode;
            }
        }
        size++;
    }

    public void Delete(int position) {
        if (size == 0) return;

        if (position == 0) {
            head = head.next;
            tail.next = head;
        } else {
            Node<E> current = head;
            for (int i = 0; i < position - 1 && current.next != head; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next == head) {
                tail = current;
            }
        }
        size--;
    }

    public Node<E> Find(E element) {
        if (size == 0) return null;

        Node<E> current = head;
        do {
            if (current.data.equals(element)) {
                return current;
            }
            current = current.next;
        } while (current != head);

        return null; // No encontrado
    }

    public void Print() {
        if (size == 0) return;

        Node<E> current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }
}

