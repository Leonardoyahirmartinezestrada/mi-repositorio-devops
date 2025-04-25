/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana3;

/**
 *
 * @author Leo_1
 */
public class PrioQueue <E>{
    NodePrio <E>[] datos;
    int size = 0;
    
    public PrioQueue() {
        this.datos = null;
        this.datos = (NodePrio<E>[]) new NodePrio[10000];
    }
    
    public void printQueue(){
        for (int i = 1; i <= size; i++){
            System.out.println(datos[i]);
        }
    }
    
    public NodePrio<E> pop() throws Exception{
        if (size == 0){
            throw new Exception ("La cola está vacía.");
        } else {
            NodePrio res = datos[1];
            NodePrio change = datos[size];
            datos[size] = new NodePrio();
            
            int hijo1;
            int hijo2;
            int currPosition = 1;
            datos[currPosition] = change;
            size--;
            
            try {
                hijo1 = datos[currPosition*2].getPrio();
            } catch (Exception e){
                hijo1 = Integer.MAX_VALUE;
            }
            
            try {
                hijo2 = datos[currPosition*2+1].getPrio();
            } catch (Exception e){
                hijo2 = Integer.MAX_VALUE;
            }
            int changePos = 0;
            
            while ((change.getPrio() > hijo1) 
                    || (change.getPrio() > hijo2)) { //para comparar con los hijos
                if(hijo1 <= hijo2){
                    changePos = currPosition*2;
                } else {
                    changePos = currPosition*2+1;
                }
                
                NodePrio temp = datos[changePos];
                datos[currPosition] = temp;
                datos[changePos] = change;
                
                currPosition = changePos;
                try { hijo1 = datos[currPosition*2].getPrio();
                } catch (Exception e){
                    hijo1 = Integer.MAX_VALUE;
                }
                
                try {
                    hijo2 = datos[currPosition*2+1].getPrio();
                } catch (Exception e){
                    hijo2 = Integer.MAX_VALUE;
                }
            }
            return res;
        }
    }
    
    public void push(int priority, E val){
        NodePrio node = new NodePrio(priority, val);
        this.size++;
        
        if (size == 1){
            datos[size] = node;
        } else {
            datos[size] = node;
            
            int currPosition = size;
            int parentPosition = (int) size/2;
            
            NodePrio<E> nodoTemp = datos[parentPosition];
            
            while (currPosition > 1 && nodoTemp.getPrio() > node.getPrio()) {
                datos[currPosition] = nodoTemp;
                datos[parentPosition] = node;
                
                currPosition = parentPosition;
                parentPosition = (int) currPosition/2;
                nodoTemp = datos[parentPosition];
                
            }
        }
    }
}
