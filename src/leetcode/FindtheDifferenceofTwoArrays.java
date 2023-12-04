package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindtheDifferenceofTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3};
        int[] nums2 = new int[] {2,4,6};
        List<List<Integer>> answer;
        answer = findDifference(nums1, nums2);
        System.out.println(answer);
    }
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = IntStream.of(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = IntStream.of(nums2).boxed().collect(Collectors.toSet());
        List<List<Integer>> answer = new ArrayList<>();

        set1.removeAll(set2);
        answer.add(set1.stream().toList());

        set1 = IntStream.of(nums1).boxed().collect(Collectors.toSet());
        set2.removeAll(set1);
        answer.add(set2.stream().toList());

        return answer;
    }
}
