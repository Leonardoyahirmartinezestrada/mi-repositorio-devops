/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avanceproyecto;

import java.util.ArrayList;

/**
 *
 * @author Leo_1
 */
public class NormalStack <E> {
    private LinkedLists<E> datos;
    private int size;
    
    public NormalStack(){
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
        Node<E> newNode = new Node <>(Task);
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
            System.out.println("\nLa tarea más reciente es: " + histTask.getDato());
        }
    }
    
    public E popStack(){
        if (isEmpty()){
            System.out.println("\nNo hay tareas urgentes.");
            return null;
        } else {
            Node <E> lastTask = this.datos.getFirst();
            while (lastTask.getNext() != null){
                lastTask = lastTask.getNext();
            }
            E taskDel = lastTask.getDato();
            this.datos.LLdelete(this.size-1);
            this.size--;
            System.out.println("\nSe ha ejecutado de la pila de urgencia: " + taskDel);
            return taskDel;
        }
    }
    
    public void popHistoryStack(){
        if (isEmpty()){
            System.out.println("\nNo hay nada que eliminar — el historial está vacío.");
        } else {
            Node <E> lastTask = this.datos.getFirst();
            while (lastTask.getNext() != null){
                lastTask = lastTask.getNext();
            }
            E taskDel = lastTask.getDato();
            this.datos.LLdelete(this.size-1);
            this.size--;
            System.out.println("\nSe ha eliminado del historial: " + taskDel);
        }
    }
    
    public void seeAllHistory(){
        if (isEmpty()){
            System.out.println("\nNo hay ninguna tarea presente en el historial.");
        }
        else {
            int n = this.size;
            System.out.println("\nExiste la siguiente cantidad de tareas en el historial: " + n);
            System.out.println("Se muestran a continuación de menos reciente a más reciente: \n");
            
            System.out.println("———————————");
            Node <E> currTask = this.datos.getFirst();
            for (int i =0; i < n; i++){
                System.out.println(currTask.getDato());
                currTask = currTask.getNext();
            }
            System.out.println("———————————");
        }
    }
    
    public void seeAllUrgentStack(){
        if (isEmpty()){
            System.out.println("\nNo hay ninguna tarea urgente en la pila de tareas urgentes.");
        }
        else {
            //organizarUrgent();
            int n = this.size;
            System.out.println("\nExiste la siguiente cantidad de tareas urgentes: " + n);
            System.out.println("Se muestran a continuación en orden de menor a mayor urgencia: \n");
            
            System.out.println("———————————");
            Node <E> currTask = this.datos.getFirst();
            for (int i =0; i < n; i++){
                System.out.println(currTask.getDato());
                currTask = currTask.getNext();
            }
            System.out.println("———————————");
        }
    }
    
    public void peekUrgentStack(){
        if (isEmpty()){
            System.out.println("\nLa pila de urgencia está vacía.");
        }
        else{
            Node<E> urgentTask = this.datos.getFirst();
            while (urgentTask.getNext()!= null){
                urgentTask = urgentTask.getNext();
            }
            System.out.println("\nLa próxima tarea urgente a ejecutar es: " + urgentTask.getDato());
        }
    }
    
    public void popUrgentStack(){
        if (isEmpty()){
            System.out.println("\nNo hay tareas urgentes para eliminar.");
        } else {
            Node <E> lastTask = this.datos.getFirst();
            while (lastTask.getNext() != null){
                lastTask = lastTask.getNext();
            }
            E taskDel = lastTask.getDato();
            this.datos.LLdelete(this.size-1);
            this.size--;
            System.out.println("\nSe ha eliminado de la pila de urgencia: " + taskDel);
        }
    }
    
    public E findInUS(int counter){
        int n = this.size;
        if (counter >= 0 && counter < n){
            return datos.find(counter);
        }
        return null;
    }
    
    public void organizarUrgent(){
        if (isEmpty() || this.size == 1) {
            return;
        }

        LinkedLists<E> organizedList = new LinkedLists<>();
        ArrayList<E> taskList = new ArrayList<>();
        Node<E> currentTask = this.datos.getFirst();
        while (currentTask != null) {
            taskList.add(currentTask.getDato());
            currentTask = currentTask.getNext();
        }
        taskList.sort((task1, task2) -> {
            if (task1 instanceof Task && task2 instanceof Task) {
                Task t1 = (Task) task1;
                Task t2 = (Task) task2;

                //como al final se agregan de la primera a la última, convertimos la última en la primera
                int priorityComparison = Integer.compare(t2.getUrgencia(), t1.getUrgencia());

                if (priorityComparison != 0) {
                    return priorityComparison;
                }

                //aquí lo ponemos al revés para que al momento de ejecutar o borrar la tarea, se haga en orden alfabético
                return t2.getDepartamento().compareToIgnoreCase(t1.getDepartamento());
            }
            return 0;
        });
        
        for (E task : taskList) {
            organizedList.LLappend(new Node<>(task));
        }

        //y aquí actualizamos ya la lista.
        this.datos = organizedList;
    }

}