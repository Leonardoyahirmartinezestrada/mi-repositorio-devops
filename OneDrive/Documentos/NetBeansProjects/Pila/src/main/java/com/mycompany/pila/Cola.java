/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pila;

/**
 *
 * @author Leo_1
 */
public class Cola<E> {
    public static final int CAPACITY = 10000;
    private E[] datos;
    private int size = 0;
    
    public Cola() {
        this.datos = (E[])new Object[this.CAPACITY];
    }
    
    public int getSize(){
        return this.size;
    }
   
    public boolean isEmpty() {
        return this.size == 0;
    }
    public void push (E element) throws Exception {
        if(this.size >= CAPACITY){
            throw new Exception("Aprendele bien");
        }
        this.datos[this.size] = element;
        this.size ++;
    }
    
    public E pop()throws Exception{
        E result=null;
        if(this.isEmpty()){
            throw new Exception("Esta vacia");
        }
        
        result = this.datos[0];
            
        for(int i = 0; i < this.size;i++){
                
            datos[i]=datos[i+1];
                
        }
        
        this.datos[this.size]=null;
            
        this.size--;
        return result;
        }
    }
}
