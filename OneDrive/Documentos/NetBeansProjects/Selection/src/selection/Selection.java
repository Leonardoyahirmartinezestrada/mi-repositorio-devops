/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selection;
import java.util.ArrayList;
/**
 *
 * @author Leo_1
 */
public class Selection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = list.size();
        
        for(int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++){
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                int temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex,temp);
                
                System.out.println(list);
            }
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(13);
        list.add(18);
        list.add(9);
        list.add(7);
        list.add(3);
        
        System.out.pirntln("Lista fea: " + list);
        
        selectionSort(list);
        
        System.out.println("Lista coqueta" + list);
        
    }
    
}
