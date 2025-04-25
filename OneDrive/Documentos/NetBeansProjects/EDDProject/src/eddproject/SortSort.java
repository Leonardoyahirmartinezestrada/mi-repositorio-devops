/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproject;
import java.util.ArrayList;
/**
 *
 * @author jairmsmz
 */
public class SortSort {
    

    public static void MergeSort(ArrayList<String> games) {
        if (games.size() <= 1) return;
        
        int mitad = games.size() / 2;
        ArrayList<String> izq = new ArrayList<>(games.subList(0, mitad));
        ArrayList<String> der = new ArrayList<>(games.subList(mitad, games.size()));
        
        MergeSort(izq);
        MergeSort(der);
        combinarVector(games, izq, der);
    }

    public static void combinarVector(ArrayList<String> games, ArrayList<String> izq, ArrayList<String> der) {
        int i = 0;
        int j = 0;
        games.clear(); 
        
        while (i < izq.size() && j < der.size()) {
            if (izq.get(i).compareTo(der.get(j)) <= 0) {
                games.add(izq.get(i));
                i++;
            } else {
                games.add(der.get(j));
                j++;
            }
        }
        
        
        while (i < izq.size()) {
            games.add(izq.get(i));
            i++;
        }
        
        
        while (j < der.size()) {
            games.add(der.get(j));
            j++;
        }
    }

    public static void imprimirVector(ArrayList<String> games) {
        if(games.isEmpty()){
            System.out.println("\nNo tienes juegos en tu biblioteca");
        } else {
            for (String game : games) {
                System.out.print(game + " ");
            }
            System.out.println();
        }  
    }
}