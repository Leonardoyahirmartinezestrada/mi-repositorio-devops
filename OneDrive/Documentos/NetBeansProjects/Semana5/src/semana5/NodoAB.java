/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana5;

/**
 *
 * @author Leo_1
 */
public class NodoAB {
    private int idx;
    private String dato;
    private NodoAB hijoIzq, hijoDer;
    
    public NodoAB(int idx, String dato) {
        this.idx = idx;
        this.dato = dato;
        this.hijoDer = null;
        this.hijoIzq = null;
    }
    
    @Override
    public String toString() {
        return dato + "Su indice es: " + idx;
    }
    
    public int getIdx() {
        return this.idx;
    }
    
    public String getDato() {
        return this.dato;
    }
    
    public NodoAB getNodoIzq() {
        return this.hijoIzq;
    }
    
    public NodoAB getNodoDer() {
        return this.hijoDer;
    }
    
    public void setNodoIzq (NodoAB izq) {
        this.hijoIzq = izq;
    }
    
    public void setNodoDer (NodoAB der) {
        this.hijoDer = der;
    }
}
