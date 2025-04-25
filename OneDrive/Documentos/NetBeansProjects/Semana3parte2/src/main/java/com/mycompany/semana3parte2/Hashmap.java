/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana3parte2;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Leo_1
 */
public class Hashmap <E> {
    public static final int size = 31;
    List<E> [] data;
    
    public Hashmap() {
        this.data = new List [size];
        for (int i = 0; i < size; i++) {
            data[i] = new ArrayList<>();
    }
    }
    
    public int hashFunction(int value) {
        int result = 0;
        
        result = (int)value % size;
        
        return result;
    }
    
    public void add(int key, E loQueSea){
        int idx = hashFunction(key);
        data[idx].add(loQueSea);
    }
    
    public E getByKey(int key) {
        int idx = hashFunction(key);
        E dato = data[idx].get(1);
        return dato;
    }
}
