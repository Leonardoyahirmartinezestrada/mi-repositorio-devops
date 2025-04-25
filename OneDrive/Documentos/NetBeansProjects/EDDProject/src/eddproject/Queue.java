/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproject;
/**
 *
 * @author jairmsmz
 */
public class Queue <E>{
    
    private LinkedLists<E> datos;
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
    
    public void addGameToPending(E Game){
        LLNode<E> game = new LLNode<>(Game);
        datos.LLappend(game);
        this.size++;
        System.out.println("\nSe ha añadido el juego " + game.toStringNode() + " a Pendientes");
    }
    
    public void seeAllPending(){
        if (isEmpty()){
            System.out.println("\nNo hay juegos pendientes");
        } else {
            int n = this.size;
            System.out.println("\nTienes la siguiente cantidad de juegos pendientes: " + n);
            System.out.println("\nSe muestran a continuación: \n");
            
            System.out.println("—————————");
            LLNode<E> currGame = this.datos.getFirst();
            for (int i = 0; i < n; i++){
                System.out.println(currGame.toStringNode());
                currGame = currGame.getNext();
            }
            System.out.println("—————————");
        }
    }
    
    public void seeNextPending(){
        if(isEmpty()){
            System.out.println("\nYa no hay juegos pendientes");
        } else {
            LLNode<E> firstGame = this.datos.getFirst();
            System.out.println("Tu próximo juego pendiente es " + firstGame.toStringNode());
        }
    }
    
    
    public LLNode<VideoGame> popPending(){
        if (isEmpty()){
            System.out.println("\nNo hay ningún juego pendiente");
            return null;
        } else {
            LLNode<VideoGame> firstGame = (LLNode<VideoGame>) this.datos.getFirst();
            //E delGame = firstGame.getDato();
            this.datos.LLdelete(0);
            this.size--;
            System.out.println("\nFelicidades, ya no está " + firstGame.getDato().getName() + " en juegos pendientes.");
            return firstGame;
        }
    }
}