/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana3;

/**
 *
 * @author Leo_1
 */
public class Semana3 {

    public static void main(String[] args) {
        
        PrioQueue<String>pq = new PrioQueue<>();
        pq.push(0,"zero");
        pq.printQueue();
        System.out.println();
        pq.push(10,"diez");
        pq.printQueue();
        System.out.println();
        pq.push(3,"tres");
        pq.printQueue();
        System.out.println();
        pq.push(100,"cien");
        pq.printQueue();
        System.out.println();
        pq.push(5,"cinco");
        pq.printQueue();
        System.out.println();
        pq.push(7,"siete");
        pq.printQueue();
        NodePrio n = pq.pop();
        pq.printQueue();
        
    }
}
