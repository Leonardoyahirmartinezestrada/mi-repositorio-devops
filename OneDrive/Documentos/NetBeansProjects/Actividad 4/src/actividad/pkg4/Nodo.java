/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg4;

/**
 *
 * @author Leo_1
 */
class Nodo {
    int id;
    Nodo izquierdo, derecho;

    public Nodo(int id) {
        this.id = id;
        izquierdo = derecho = null;
    }
}
// Explicación del codigo:
// Representa cada nodo del árbol binario. Cada nodo contiene un valor (dato) y referencias a sus nodos hijos izquierdo y derecho.
