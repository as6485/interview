package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int [] nums = {1,2,3};

        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        generateSubsets(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    //Subsets coding pattern with backtracking.
    private static void generateSubsets(int[] arr, List<Integer> currentPermutation, List<List<Integer>> permutations) {

        if(currentPermutation.size() == arr.length){
            permutations.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!currentPermutation.contains(arr[i])) {
                currentPermutation.add(arr[i]);
                generateSubsets(arr, currentPermutation, permutations);
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }
}
