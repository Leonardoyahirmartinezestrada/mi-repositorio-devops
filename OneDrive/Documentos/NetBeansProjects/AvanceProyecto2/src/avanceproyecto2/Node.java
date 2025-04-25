/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avanceproyecto2;

/**
 *
 * @author Leo_1
 */
public class Node <E> {
    private E dato;
    private Node<E> next;
    
    public Node(E val){
        this.dato = val;
    }
    
    public Node(E val, Node<E> n){
        this.dato = val;
        this.next = n;
    }

    /**
     * @return the dato
     */
    public E getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(E dato) {
        this.dato = dato;
    }

    /**
     * @return the next
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
}