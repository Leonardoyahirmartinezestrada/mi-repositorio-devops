/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproject;

/**
 *
 * @author jairmsmz
 */
public class BTNode {
    private int index;
    private String name;
    private BTNode leftChild, rightChild;
    
    public BTNode(int index, String name){
        this.index = index;
        this.name = name;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the leftChild
     */
    public BTNode getLeftChild() {
        return leftChild;
    }

    /**
     * @param leftChild the leftChild to set
     */
    public void setLeftChild(BTNode leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * @return the rightChild
     */
    public BTNode getRightChild() {
        return rightChild;
    }

    /**
     * @param rightChild the rightChild to set
     */
    public void setRightChild(BTNode rightChild) {
        this.rightChild = rightChild;
    }
    
    
    public String toStringBT(){
        return getName() + getIndex();
    }
}