/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana4;
import java.util.Stack;
/**
 *
 * @author Leo_1
 */
public class Semana4 {

    public static void main(String[] args) {
        /*RecursiveAlgo ra = new RecursiveAlgo();
        // long numerote = Long.MAX_VALUE +1;
        //numerote = ra.fact(53);
        // System.out.println(numerote);
        int [] a ={2, 50, 1, 3, 4};
        int num = ra.encontrarMax(a, 0, a.length-1);
        System.out.println(num);
        */
       /*RecursiveAlgo ra = new RecursiveAlgo();
       Stack<Integer> origin = new Stack<>();
       Stack<Integer> destiny = new Stack<>();
       Stack<Integer> aux = new Stack<>();
       
       for(int i = 0; i < 4; i++) {
           origin.push(i);
       }
       System.out.println(origin);
       System.out.println(destiny);
       System.out.println(aux);
       System.out.println();
       
       ra.hanoi(origin, destiny, aux, 4);
       
       System.out.println();
       System.out.println(origin);
       System.out.println(destiny);
       System.out.println(aux);
       */
       
       RecursiveAlgo ra = new RecursiveAlgo();
       
       ra.nQueens(4);
    }
}
