/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act2;

/**
 *
 * @author Leo_1
 */
//Stack en este caso es el historial
//pushStack() es para almacenar las tareas en ejecución
//popStack() es para borrar LA ÚLTIMA/MOST RECENT tarea del historial
//peekStack() es para REVISAR LA ÚLTIMA/MOST RECENT tarea ejecutada
public class Stack <E> {
    private LinkedLists<E> datos;
    private int size;
    
    public Stack(){
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
    
    public void pushStack(E Task){
        Node<E> newNode = new Node <>(Task); //convierto la tarea en nodo para agregarla a la linkedlist
        this.datos.LLappend(newNode);
        this.size++;
    }
    
    public void peekStack(){
        if (isEmpty()){
            System.out.println("\nEl historial está vacío.");
        }
        else{
            Node<E> histTask = this.datos.getFirst();
            while (histTask.getNext()!= null){
                histTask = histTask.getNext();
            }
            System.out.println("\nLa última tarea realizada fue: " + histTask.getDato() + ".");
        }
    }
    
    public void popStack(){
        if (isEmpty()){
            System.out.println("\nNo hay nada que eliminar — el historial está vacío.");
        } else {
            Node <E> lastTask = this.datos.getFirst();
            E taskDel = lastTask.getDato();
            this.datos.LLdelete(this.size-1);
            this.size--;
            System.out.println("\nSe ha eliminado " + taskDel + " del historial.");
        }
    }
}
