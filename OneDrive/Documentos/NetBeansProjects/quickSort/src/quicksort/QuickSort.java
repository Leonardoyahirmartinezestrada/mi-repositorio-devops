/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quicksort;

/**
 *
 * @author Leo_1
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = {10, 80, 30, 90, 40};
        QuickSort ra = new QuickSort();
        
        for(int val: a)
            System.out.print(val + " ");
        
        System.out.println();
        
        ra.quickSort(a,0,a.length-1);
        
        for (int val : a)
            System.out.print(val + " ");
        
        System.out.println();
    }
    
    public static int partition(int[] arr, int low, int high) {
        
        int pivot = arr[high];
        
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        
        return (i+1);
    }
    
    public static void quickSort (int[] arr, int low, int high) {
        
        if (low < high) {
            int idx = partition(arr, low, high);
        
            quickSort(arr, low, idx-1);
            quickSort(arr, idx+1, high);
        }
    }
    
}
