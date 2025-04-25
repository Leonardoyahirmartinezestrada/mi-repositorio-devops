/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pila;

/**
 *
 * @author Alumno
 */
public class Pilas<E> {
   
    public final int CAPACITY = 10000;
    private E[] datos;
    private int size;
   
    public Pilas() {
        this.size = 0;
        this.datos = (E[])new Object[this.CAPACITY];
    }
   
    public E[] getDatos() {
        return this.datos;
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
    public void peek(){
        if(isEmpty()){
            System.out.println("La pila esta vacia :o");
        } else {
            System.out.println("El elemento del top es:" + this.datos[size-1]);
        }
    }
    public E pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("La pila esta vacia :o");
        } else {
           E temp = this.datos[size-1];
           this.size--;
           return temp;
        }
    }

}
