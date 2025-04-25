/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproject;

/**
 *
 * @author jairmsmz
 */
public class LinkedLists <E> {
    LLNode <E> first;
    
    public LinkedLists(){
        this.first = null;
    }
    
    public LinkedLists(LLNode <E> n){
        this.first = n;
    }
    
    public LLNode<E> getFirst(){
        return first;
    }
    
    public void printList(){
        LLNode<E> currNode = this.first;
        while (currNode != null){
            System.out.println(currNode.getDato());
            currNode = currNode.getNext();
        }
    }
    
    public void LLappend(LLNode <E> n){
        if (this.first == null){
            this.first = n;
        } else {
            LLNode <E> currNode = this.first;
            while (currNode.getNext() != null){
                currNode = currNode.getNext();
            }
            currNode.setNext(n);
        }
    }
    
    public int LLsize(){
        LLNode<E> currNode = this.first;
        int counter = 0;
        while (currNode != null){
            currNode = currNode.getNext();
            counter++;
        }
        return counter;
    }
    
    
    public void LLinsert(LLNode<E> n, int pos){
        int s = this.LLsize();
        
        if ((pos > s) || (pos < 0)){
            return;
        }
        
        if (pos == 0){
            n.setNext(this.first);
            this.first = n;
        } else {
            LLNode <E> currNode = this.first;
            
            for (int i = 0; i < pos-1; i++){
                currNode = currNode.getNext();
            }
            
            LLNode <E> currNode2 = currNode.getNext();
            currNode.setNext(n);
            n.setNext(currNode2);
        }
    }
    
    public void LLdelete(int pos){
        int s = this.LLsize();
        LLNode <E> previous = null;
        LLNode <E> temp = this.first;
        
        if ((s==0) || (pos >= s) || (pos <0)){
            return;
        }
        
        if (pos == 0){
            this.first = temp.getNext();
            return;
        }
        
        for(int i = 0; i < pos; i++){
            previous = temp;
            temp = temp.getNext();
        }
        
        previous.setNext(temp.getNext());
    }
    
    
    public LLNode<VideoGame> findByName(String name) {
    LLNode<VideoGame> currNode = (LLNode<VideoGame>) this.first;
    while (currNode != null) {
        if (currNode.getDato().getName().equalsIgnoreCase(name)) {
            return currNode; 
        }
        currNode = currNode.getNext();
    }

    return null;
}
    
    
    public String toStringLL() {
        if (this.first == null) {
            return "(No hay nada)";
        }
        
        String res = "";
        LLNode<E> currNode = this.first;
        
        while (currNode != null) {
            res += currNode.getDato().toString();
            currNode = currNode.getNext();
            if (currNode != null) {
                res += " >> ";
            }
        }
        return res;
    }
}