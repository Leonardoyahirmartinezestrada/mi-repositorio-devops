/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad1;

/**
 *
 * @author Leo_1
 */
public class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}

    
    class SinglyLinkedList<E> {
        private Node<E> head;

        public SinglyLinkedList() {
            this.head = null;
    }

    public void Insert(E element, int place) {
        Node<E> newNode = new Node<>(element);
        if (place == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node<E> current = head;
        for (int i = 0; i < place - 1 && current != null; i++) {
            current = current.next;
        }
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void Delete(int place) {
        if (place == 0 && head != null) {
            head = head.next;
            return;
        }
        Node<E> current = head;
        for (int i = 0; i < place - 1 && current != null; i++) {
            current = current.next;
        }
        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
    }

    public Node<E> Find(E element) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void Print() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
