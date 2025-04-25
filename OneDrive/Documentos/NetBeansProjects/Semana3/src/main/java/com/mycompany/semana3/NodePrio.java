/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana3;

/**
 *
 * @author Leo_1
 */
public class NodePrio <E>{
    private int prio;
    private E dato;
    
    public NodePrio() {
        this.dato = null;
        this.prio = Integer.MAX_VALUE;
    
    }
    
    public NodePrio(int prio, E dato) {
        this.dato = dato;
        this.prio = prio;
    }
    
    public int getPrio() {
        return prio;
    }
    
    public E getDato(){
        return dato;
    }
    public void setPrio(int p) {
        this.prio =  p;
    }
    public void setDato(E d) {
        this.dato = d;
    }
    @Override
    public String toString(){
        return "Priority: " + prio + " Dato: " + dato;
    }
}
