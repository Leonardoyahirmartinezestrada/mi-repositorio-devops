/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act2;

/**
 *
 * @author Leo_1
 */
public class Queue <E>{
    private LinkedLists<E> datos; //usar linkedLists
    private int size;
    
    public Queue(){
        datos = new LinkedLists<>();
    }
    
    public LinkedLists<E> getDatos(){
        return this.datos;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    public void pushQ(E Task){
        Node<E> tarea = new Node<>(Task); //convierto la tarea en un nodo para poder agregarla a la LinkedList
        datos.LLappend(tarea); //se agreaga a la linked list (datos)
        this.size++; //si bie  el size no se utiliza en las linked lists, nos sirve para ir modificando y verificando si hay o no hay elementos en la cola
        System.out.println("\nSe ha añadido la tarea: " + Task + ".");
    }
    
    public E popQ(){
        if (isEmpty()){
            System.out.println("\nNo hay ninguna tarea por ejecutar.");
            return null;
        } else {
            Node <E> firstTask = this.datos.getFirst();
            E taskEx = firstTask.getDato();
            this.datos.LLdelete(0);
            this.size--;
            System.out.println("\nSe ha ejecutado la tarea: " + taskEx + ".");
            return taskEx;
        }
    }
    
    public E front() {
        if (isEmpty()) {
            System.out.println("\nNo hay ninguna tarea por ejecutar.");
            return null;
        } else {
            Node<E> firstTask = this.datos.getFirst();
            E taskEx = firstTask.getDato();
            System.out.println("\nLa próxima tarea por ejecutar es: " + taskEx + ".");
            return taskEx;
        }
    }
}

