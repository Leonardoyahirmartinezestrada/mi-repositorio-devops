/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproject;

/**
 *
 * @author jairmsmz
 */
public class BinaryTree {
    
    BTNode root;
    
    public BinaryTree(){
        this.root = null;
    }
    
    public void inOrdenRating(BTNode node){
        if(node == null){
            return;
        }
        inOrdenRating(node.getLeftChild());
        System.out.println("Juego: " + node.getName() + " ———— Puntuación: " + node.getIndex());
        inOrdenRating(node.getRightChild());
    }
    
    
    public void inOrdenMinutes(BTNode node){
        if(node == null){
            return;
        }
        inOrdenMinutes(node.getLeftChild());
        System.out.println("Juego: " + node.getName() + " ———— Minutos jugados: " + node.getIndex());
        inOrdenMinutes(node.getRightChild());
    }
    
    public void printInOrdenRating(){
        if (root == null) {
            System.out.println("\nNo hay juegos en tu biblioteca");
        } else {
            inOrdenRating(this.root);
        }
    }
    
    public void printInOrdenMinutes(){
        if (root == null) {
            System.out.println("\nNo hay juegos en tu biblioteca");
        } else {
            inOrdenMinutes(this.root);
        }
    }
    
    public int depthOfTree(BTNode node){
        if(node == null){
            return 0;
        }
        
        int leftChild = depthOfTree(node.getLeftChild());
        int rightChild = depthOfTree(node.getRightChild());
        
        if (leftChild > rightChild){
            return 1+leftChild;
        } else {
            return 1+rightChild;
        }
    }
    
    public void printDepth(){
        System.out.println(depthOfTree(root));
    }
    
    public void insertInTree(int index, String name){
        BTNode newTreeNode = new BTNode(index, name);
        
        if(root == null){
            root = newTreeNode;
        } else {
            BTNode currentNode = root;
            BTNode ancestor;
            
            while(true){
                ancestor = currentNode;
                if (newTreeNode.getIndex() > currentNode.getIndex()){
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null){
                        ancestor.setRightChild(newTreeNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null){
                        ancestor.setLeftChild(newTreeNode);
                        return;
                    }
                }
            }
            
        }
    }
    
    
    public void findInTree(int index){
        BTNode curr = root;
        BTNode temp = null;
        
        while(curr != null){
            if(curr.getIndex() < index){
                temp = curr;
                curr = curr.getRightChild();
            } else if (curr.getIndex() > index){
                temp = curr;
                curr = curr.getLeftChild();
            } else {
                System.out.println("Se encontró a >" + curr.getName() + "< con una puntuación de: *" + curr.getIndex() + "*" + 
                        "\nEstá por debajo de: >" + (temp != null ? temp.getName() + "< con una puntuación de: *" + temp.getIndex() + "*": "nada<") + 
                        "\ny está por encima de: >" + (curr.getLeftChild() != null ? curr.getLeftChild().getName() + " con una puntuación de *" + curr.getLeftChild().getIndex() + "*": "nada<") + 
                        "\ny de: >" + (curr.getRightChild() != null ? curr.getRightChild().getName() + "< con una puntuación de: *" + curr.getRightChild().getIndex() + "*\n": "nada<.\n"));
                return;
            }
        }
        if (curr ==null){
            System.out.println("\nNo existe un videojuego con esa puntuación.\n");
        }
    }
    
    public void deleteMinsInTree(int index, String name){
        BTNode delNode = new BTNode(index, name);
        
        BTNode currentNode = root;
        BTNode ancestor = null;
        
        if(root == null){
            System.out.println("No hay videojuegos.\n");
            return;
        }
        
        while((currentNode != null) && (currentNode.getIndex() != delNode.getIndex())){
            ancestor = currentNode;
            if(delNode.getIndex() < currentNode.getIndex()) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }
        
        if (currentNode == null){
            System.out.println("\nNo se encontró el videojuego con esos minutos jugados: *" + index + "*\n");
            return;
        }
        if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null){
            if (currentNode == root) {
                root = null;
            } else {
                if (ancestor.getLeftChild() == currentNode) {
                    ancestor.setLeftChild(null);
                } else {
                    ancestor.setRightChild(null);
                }
            }
            System.out.println("\nSe eliminó a >" + name + "< con *" + index + "* minutos jugados de la lista de juegos\n");
        }
        
        else if ((currentNode.getLeftChild() == null) || (currentNode.getRightChild() == null)){
            BTNode newChild = (currentNode.getLeftChild() != null ? currentNode.getLeftChild() : currentNode.getRightChild());
            if (currentNode == root) {
                root = newChild;
            } else {
                if (ancestor.getLeftChild() == currentNode) {
                    ancestor.setLeftChild(newChild);
                } else {
                    ancestor.setRightChild(newChild);
                }
            }
            System.out.println("\nSe eliminó a >" + name + "< con sus minutos jugados *" + index + "* de la lista de juegos\n");
        }
        
        else {
            BTNode nextChild = currentNode.getRightChild();
            BTNode nextAncestor = currentNode;
            
            while(nextChild.getLeftChild() != null){
                nextAncestor = nextChild;
                nextChild = nextChild.getLeftChild();
            }
            
            currentNode.setIndex(nextChild.getIndex());
            currentNode.setName(nextChild.getName());
           
            if(nextAncestor.getLeftChild() == nextChild){
                nextAncestor.setLeftChild(nextChild.getRightChild());
            } else {
                nextAncestor.setRightChild(nextChild.getRightChild());
            }
            System.out.println("\nSe eliminó a >" + name + "< con sus minutos jugados *" + index + "* de la lista de juegos\n");
        }
    }
    
    public void deleteRateInTree(int index, String name){
        BTNode delNode = new BTNode(index, name);
        
        BTNode currentNode = root;
        BTNode ancestor = null;
        
        if(root == null){
            System.out.println("No hay videojuegos reseñados.\n");
            return;
        }
        
        while((currentNode != null) && (currentNode.getIndex() != delNode.getIndex())){
            ancestor = currentNode;
            if(delNode.getIndex() < currentNode.getIndex()) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }
        
        if (currentNode == null){
            System.out.println("\nNo se encontró el videojuego con esa puntuación: *" + index + "*\n");
            return;
        }
        if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null){
            if (currentNode == root) {
                root = null;
            } else {
                if (ancestor.getLeftChild() == currentNode) {
                    ancestor.setLeftChild(null);
                } else {
                    ancestor.setRightChild(null);
                }
            }
            System.out.println("\nSe eliminó a >" + name + "< con su puntuación *" + index + "* de la lista de reseñas\n");
        }
        
        else if ((currentNode.getLeftChild() == null) || (currentNode.getRightChild() == null)){
            BTNode newChild = (currentNode.getLeftChild() != null ? currentNode.getLeftChild() : currentNode.getRightChild());
            if (currentNode == root) {
                root = newChild;
            } else {
                if (ancestor.getLeftChild() == currentNode) {
                    ancestor.setLeftChild(newChild);
                } else {
                    ancestor.setRightChild(newChild);
                }
            }
            System.out.println("\nSe eliminó a >" + name + "< con su puntuación *" + index + "* de la lista de reseñas\n");
        }
        
        else {
            BTNode nextChild = currentNode.getRightChild();
            BTNode nextAncestor = currentNode;
            
            while(nextChild.getLeftChild() != null){
                nextAncestor = nextChild;
                nextChild = nextChild.getLeftChild();
            }
            
            currentNode.setIndex(nextChild.getIndex());
            currentNode.setName(nextChild.getName());
           
            if(nextAncestor.getLeftChild() == nextChild){
                nextAncestor.setLeftChild(nextChild.getRightChild());
            } else {
                nextAncestor.setRightChild(nextChild.getRightChild());
            }
            System.out.println("\nSe eliminó a >" + name + "< con su puntuación *" + index + "* de la lista de reseñas\n");
        }
    }
    
}