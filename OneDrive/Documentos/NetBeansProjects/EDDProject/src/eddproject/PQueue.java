/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproject;

/**
 *
 * @author jairmsmz
 */
public class PQueue <E>{
    
    PQNode <E>[] games;
    int size = 0;
    
    public PQueue() {
        this.games = null;
        this.games = (PQNode<E>[]) new PQNode[10000];
    }
    
    public void printFirstOfPQueue(){
        if (size == 0){
            System.out.println("\nYa no tienes juegos pre-ordenados registrados");
        } else {
            if (games[1] != null){
                System.out.println(games[1].toStringPQ());
            }
            else{
               System.out.println("\nYa no tienes juegos pre-ordenados registrados"); 
            }
        }
    }
    
    public void printPQueue(){
        if (size == 0){
            System.out.println("\nNo tienes juegos pre-ordenados registrados");
        } else {
            for (int i = 1; i <= size; i++){
                System.out.println(games[i].toStringPQ());
            }
        }
    }
    
    public PQNode<E> popPQ() throws Exception {
        if(size == 0){
            System.out.println("\nNo tienes juegos pre-ordenados registrados");
            return null;
        } else {
            PQNode<E> res = games[1];
            PQNode change = games[size];
            games[size] = new PQNode();
            
            int child1, child2;
            int currPosition = 1;
            games[currPosition] = change;
            size--;
            
            try{
                child1 = games[currPosition*2].getPrio();
            } catch (Exception e) {
                child1 = Integer.MAX_VALUE;
            }
            
            try {
                child2 = games[currPosition*2+1].getPrio();
            } catch (Exception e){
                child2 = Integer.MAX_VALUE;
            }
            int changePos = 0;
            
            while ((change.getPrio() > child1) || (change.getPrio() > child2)){
                if (child1 <= child2){
                    changePos = currPosition*2;
                } else {
                    changePos = currPosition*2+1;
                }
                
                PQNode temp = games[changePos];
                games[currPosition] = temp;
                games[changePos] = change;
                
                currPosition = changePos;
                try {
                    child1 = games[currPosition*2].getPrio();
                } catch (Exception e){
                    child1 = Integer.MAX_VALUE;
                }
                
                try {
                    child2 = games[currPosition*2+1].getPrio();
                } catch (Exception e) {
                    child2 = Integer.MAX_VALUE;
                }
            }
            return res;
        }
    }
    
    public void pushPQ(int priority, E val){
        PQNode <E> node = new PQNode<>(priority, val);
        this.size++;
        
        if (size == 1){
            games[size] = node;
        } else {
            games[size] = node;
            
            int currPosition = size;
            int parentPosition = (int) size/2;
            
            PQNode<E> nodoTemp = games[parentPosition];
            
            while (currPosition > 1 && nodoTemp.getPrio() > node.getPrio()) {
                games[currPosition] = nodoTemp;
                games[parentPosition] = node;
                
                currPosition = parentPosition;
                parentPosition = (int) currPosition/2;
                nodoTemp = games[parentPosition];
            }
        }
    }
}