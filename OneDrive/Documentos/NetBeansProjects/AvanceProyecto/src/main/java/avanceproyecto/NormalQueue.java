/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avanceproyecto;

/**
 *
 * @author Leo_1
 */
public class NormalQueue <E>{
    private LinkedLists<E> datos; //usar linkedLists
    private int size;
    
    public NormalQueue(){
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
        this.size++; //si bien  el size no se utiliza en las linked lists, nos sirve para ir modificando y verificando si hay o no hay elementos en la cola
        System.out.println("\nSe ha añadido la tarea: " + Task);
    }
    
    public void front(){
        if (isEmpty()) {
            System.out.println("\nNo hay ninguna tarea próxima por ejecutar.");
        } else {
            Node<E> firstTask = this.datos.getFirst();
            E taskEx = firstTask.getDato();
            System.out.println("\nLa próxima tarea por ejecutar es: " + taskEx);
        }
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
            System.out.println("\nSe ha ejecutado la tarea: " + taskEx);
            return taskEx;
        }
    }
    
    public void seeAllQ(){
        if (isEmpty()){
            System.out.println("\nNo hay ninguna tarea presente en la cola de ejecución");
        }
        else {
            int n = this.size;
            System.out.println("\nQueda el siguiente número de tareas en la cola de ejecución: " + n);
            System.out.println("Se muestran a continuación: \n");
            
            System.out.println("———————————");
            Node <E> currTask = this.datos.getFirst();
            for (int i =0; i < n; i++){
                System.out.println(currTask.getDato());
                currTask = currTask.getNext();
            }
            System.out.println("———————————");
        }
    }
    
    public void popTaskQ(){
        if (isEmpty()){
            System.out.println("\nNo hay ninguna tarea para borrar.");
        } else {
            Node <E> firstTask = this.datos.getFirst();
            E taskEx = firstTask.getDato();
            this.datos.LLdelete(0);
            this.size--;
            System.out.println("\nSe ha borrado la tarea: " + taskEx);
        }
    }
    
    public E findInQ(int counter){
        int n = this.size;
        if (counter >= 0 && counter < n){
            return datos.find(counter);
        }
        return null;
    }
    
}
