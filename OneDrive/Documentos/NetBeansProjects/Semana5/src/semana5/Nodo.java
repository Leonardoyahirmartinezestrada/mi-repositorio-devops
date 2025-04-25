/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana5;

/**
 *
 * @author Leo_1
 */
public class Nodo {
    int valor;
    Nodo izquierda, derecha;
    
    public Nodo(int valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }
}
