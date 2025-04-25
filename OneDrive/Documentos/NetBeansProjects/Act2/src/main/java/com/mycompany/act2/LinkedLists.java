/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act2;

/**
 *
 * @author Leo_1
 */
public class LinkedLists <E> {
    
    Node <E> first;
    
    public LinkedLists(){
        this.first = null;
    }
    
    public LinkedLists(Node <E> n){
        this.first = n;
    }
    
    public Node<E> getFirst(){
        return first;
    }
    
    
    public void printList(){
        Node <E> currNode = this.first;
        while (currNode != null){
            System.out.println(currNode.getDato());
            currNode = currNode.getNext();
        }
    }
    
    public void LLappend(Node <E> n){
        if (this.first == null){
            this.first = n;
        } else {
            Node <E> currNode = this.first;
            while (currNode.getNext() != null){
                currNode = currNode.getNext();
            }
            currNode.setNext(n);
        }
    }
    
    public int LLsize(){
        Node<E> currNode = this.first;
        int counter = 0;
        while (currNode != null){
            currNode = currNode.getNext();
            counter++;
        }
        return counter;
    }
    
    public void LLinsert(Node <E> n, int pos){
        int s = this.LLsize();
        
        if ((pos > s) || (pos < 0)){
            System.out.println("La posición deseada no existe.");
            return;
        }
        
        if (pos == 0){
            n.setNext(this.first);
            this.first = n;
        } else {
            Node <E> currNode = this.first;
            
            for (int i = 0; i < pos-1; i++){
                currNode = currNode.getNext();
            }
            
            Node <E> currNode2 = currNode.getNext();
            currNode.setNext(n);
            n.setNext(currNode2);
        }
    }
    
    public void LLdelete(int pos){
        int s = this.LLsize();
        Node <E> previous = null;
        Node <E> temp = this.first;
        
        if ((s == 0) || (pos >= s) || (pos < 0)){
            System.out.println("La posición deseada no se puede borrar.");
            return;
        }
        
        if (pos == 0){
            this.first = temp.getNext();
            return;
        }
        
        for (int i = 0; i < pos; i++){
            previous = temp;
            temp = temp.getNext();
        }
        
        previous.setNext(temp.getNext());
    }
    
    public void find(int n){
        int pos = 0;
        Node<E> currNode = this.first;
        
        while (currNode != null){
            if (currNode.getDato().equals(n)){
                System.out.println("El nodo está en la posición " + pos);
                return;
            } else{
                pos++;
                currNode = currNode.getNext();
            }
        }
        System.out.println("No existe un nodo nodo con ese valor");
    }
    
}
