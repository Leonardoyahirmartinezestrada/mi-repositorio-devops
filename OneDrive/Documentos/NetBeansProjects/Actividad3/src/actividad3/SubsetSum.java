/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad3;

/**
 *
 * @author Leo_1
 */
public class SubsetSum {
    public static boolean existeSubconjunto(int[] nums, int objetivo) {
        return subsetSumRec(nums, nums.length - 1, objetivo);
    }

    private static boolean subsetSumRec(int[] nums, int n, int objetivo) {
        if (objetivo == 0) {
            return true;
        }
        if (n < 0 || objetivo < 0) {
            return false;
        }
        return subsetSumRec(nums, n - 1, objetivo - nums[n]) || subsetSumRec(nums, n - 1, objetivo);
    }
}

