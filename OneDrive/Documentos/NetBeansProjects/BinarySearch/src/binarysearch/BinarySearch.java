/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarysearch;

/**
 *
 * @author Leo_1
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] b = {1,2,3,4,5,6};
        
        int res = binarySearch(b,6);
        
        System.out.print("La respuesta es: " + res);
    }
    
    public static int binarySearch(int arr[], int x) {
        int low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            System.out.println(mid);
            
            if (x == arr[mid])
                return mid;
            
            if (arr[mid] < x)
                low = mid + 1;
            
            if (arr[mid] < x)
                high = mid - 1;
        }
        
        return -9999;
    }
}
