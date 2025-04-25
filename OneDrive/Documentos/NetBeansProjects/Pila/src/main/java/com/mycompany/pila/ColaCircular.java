/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pila;

import java.util.ArrayList;
/**
 *
 * @author Leo_1
 */
public class ColaCircular <E>{
    int front = -1;
    int rear = -1;
    ArrayList<E> datos = new ArrayList<>();
    
    public void push(E dato) {
        if(front == rear) {
            front += 1;
            rear += 1;
            datos.add(dato);
        } else {
            rear += 1;
            datos.add(rear,dato);
            
        }
    }
    
    public E pop() throws Exception{
        if(front == rear) {
            throw new Exception("No le sabes");
        } else {
            E dato = this.datos.get(front);
            front += 1;
            return dato;
            
            
            
            //Segunda forma
            //this.datos.remove(0);
            //rear -= 1;
            
            //if (rear == 0)// 
            // Segunda forma
        }
    }
}
