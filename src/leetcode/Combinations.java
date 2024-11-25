package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(n, k, 1, new ArrayList<>(), subsets);
        return subsets;
    }

    //Subsets coding pattern with backtracking. Number of subsets is 2^n
    private static void generateSubsets(int n, int k, int start, List<Integer> currentCombination, List<List<Integer>> subsets) {
        //we are only interested in subsets of size k, rest we ignore
        if (currentCombination.size() == k) {
            subsets.add(new ArrayList<>(currentCombination));
            return;
        }
        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            generateSubsets(n, k, i + 1, currentCombination, subsets);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
