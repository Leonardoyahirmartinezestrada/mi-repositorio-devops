/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproject;

/**
 *
 * @author jairmsmz
 */
public class LLNode <E> {
    private E dato;
    private LLNode<E> next;
    
    public LLNode (E val){
        this.dato = val;
    }
    
    public LLNode (E val, LLNode <E> n){
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
    public LLNode<E> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(LLNode<E> next) {
        this.next = next;
    }
    
    
    public String toStringNode(){
        return "" + getDato() + "";
    }
}