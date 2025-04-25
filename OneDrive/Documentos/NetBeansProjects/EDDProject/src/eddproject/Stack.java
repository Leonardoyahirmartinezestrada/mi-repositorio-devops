/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproject;



/**
 *
 * @author jairmsmz
 */
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
    
    public void pushGameToRecent(E Game){
        LLNode<E> newNode = new LLNode <>(Game);
        this.datos.LLappend(newNode);
        this.size++;
    }
    
    public void peekRecentGame(){
        if (isEmpty()){
            System.out.println("\nNo hay juegos recientes");
        }
        else{
            LLNode<E> histGame = this.datos.getFirst();
            while (histGame.getNext()!= null){
                histGame = histGame.getNext();
            }
            System.out.println("\nEl juego más recientemente explorado es: " + histGame.toStringNode());
        }
    }
    
    public void popStack(){
        if (isEmpty()){
            System.out.println("\nNo hay juegos recientes.");
        } else {
            LLNode <E> lastGame = this.datos.getFirst();
            
            while (lastGame.getNext() != null){
                lastGame = lastGame.getNext();
            }
            
            LLNode<E> gameDel = (LLNode<E>) lastGame.getDato();
            this.datos.LLdelete(this.size-1);
            this.size--;
            System.out.println("\nSe ha eliminado de Juegos Recientes: " + gameDel.getDato());
            //return gameDel;
        }
    }
    
    
    public void seeAllRecentGames(){
        if (isEmpty()){
            System.out.println("\nNo hay ningun juego presente en Juegos Recientes.");
        }
        else {
            int n = this.size;
            System.out.println("\nExiste la siguiente cantidad de Juegos Recientes: " + n);
            System.out.println("Se muestran a continuación de menos reciente a más reciente: \n");
            
            System.out.println("———————————");
            LLNode <E> currGame = this.datos.getFirst();
            for (int i =0; i < n; i++){
                System.out.println(currGame.getDato());
                currGame = currGame.getNext();
            }
            System.out.println("———————————");
        }
    }
}