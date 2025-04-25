/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana5;

/**
 *
 * @author Leo_1
 */
public class ArbolBinario {
    NodoAB root;
    
    public ArbolBinario(){
        this.root = null;
    }
    
    public void inOrden(NodoAB n){
        if (n == null)
             return;
           inOrden(n.getNodoIzq());
           System.out.println(n.getDato());
           inOrden(n.getNodoDer());
    }
    
    public void printIO() {
        inOrden(this.root);
    }
    
    public void insert(int idx, String dato) {
        NodoAB nuevo = new NodoAB(idx, dato);
        
        if (root == null) {
            root = nuevo;
        } else {
            NodoAB curr = root;
            NodoAB father;
            
            while (true) {
                father = curr;
                if (nuevo.getIdx() > curr.getIdx()) {
                curr = curr.getNodoDer();
                if (curr == null){
                    father.setNodoDer(nuevo);
                    return;
                }
            } else {
                curr = curr.getNodoIzq();
                if (curr == null){
                    father.setNodoIzq(nuevo);
                    return;
                }
            }
        }
    }
}
    
}
