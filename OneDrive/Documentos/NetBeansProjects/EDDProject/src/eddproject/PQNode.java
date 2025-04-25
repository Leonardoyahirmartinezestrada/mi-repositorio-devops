/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproject;
/**
 *
 * @author jairmsmz
 */
public class PQNode <E> {
    private int prio;
    private E dato;
    
    public PQNode() {
        this.dato = null;
        this.prio = Integer.MAX_VALUE;
    }
    
    public PQNode(int prio, E dato){
        this.prio = prio;
        this.dato = dato;
    }

    /**
     * @return the prio
     */
    public int getPrio() {
        return prio;
    }

    /**
     * @param prio the prio to set
     */
    public void setPrio(int prio) {
        this.prio = prio;
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
    
    public String toStringPQ(){
        return "Días restantes: " + getPrio() + " | Título: " + getDato().toString();
    }
}