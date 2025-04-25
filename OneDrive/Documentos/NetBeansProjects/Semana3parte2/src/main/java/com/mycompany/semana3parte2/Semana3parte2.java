/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana3parte2;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Leo_1
 */
public class Semana3parte2 {

    public static void main(String[] args) {
        /*
        Hashmap<String> h = new Hashmap<>();
        h.add(1, "Supercalifragillisticoespiralidoso");
        h.add(32, "aaa");
        System.out.println(h.getByKey(32));
        */
        /*
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        String str = "papas";
        
        for(int i = 0; i < str.length(); i++) {
            if (h.containsKey(str.charAt(i))) {
                h.put(str.charAt(i), h.get(str.charAt(i))+1);
            } else {
                h.put(str.charAt(i),1);
            }
        }
        
        System.out.println(h);
        */
        int target = 2;
        int[] n = {1,4,8,7,0,6};
        int res;
        
        int counter = 0;
        HashMap<Integer, int []> h = new HashMap<>();
        
        for (int i = 0; i < n.length; i++) {
            for (int j = i+1; j < n.length; j++ ){
                res = Math.abs(n[i] - n[j]);
                if (res == target) {
                    int q = n[i], w = n[j];
                    int [] temp = {n[i], n[j]};
                    h.put(counter, temp);
                    counter++;
                }
            }
        }
        System.out.print(h.get(0)[0]);
        System.out.println(h.get(0)[1]);
        
        System.out.print(h.get(1)[0]);
        System.out.println(h.get(1)[1]);
    }
}
