/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana5;

/**
 *
 * @author Leo_1
 */
public class ArbolBinario2 {
    Nodo raiz;
    
    public ArbolBinario2() {
        raiz = null;
    }
    
    public int profundidad(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int profundidadIzquierda = profundidad(nodo.izquierda);
            int profundidadDerecha = profundidad(nodo.derecha);
            
            return Math.max(profundidadIzquierda, profundidadDerecha) + 1;
        }
    }
}
