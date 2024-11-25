package javabasics.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(4, 1, new ArrayList<>(), subsets);
        System.out.println(subsets);
    }

    //Subsets coding pattern with backtracking. Number of subsets is 2^n
    private static void generateSubsets(int n, int start, List<Integer> currentCombination, List<List<Integer>> subsets) {

        subsets.add(new ArrayList<>(currentCombination));

        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            generateSubsets(n, i + 1, currentCombination, subsets);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

}
