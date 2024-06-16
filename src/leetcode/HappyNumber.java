package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HappyNumber {

    private static HashMap<Integer, Integer> hm;

    public static void main(String[] args) {
        int n = 2;
        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(n, 1);

        while (true) {
            List<Integer> digits = getDigits(n);
            for (int digit : digits) {
                sum += digit * digit;
            }
            if (sum == 1)
                return true;
            else if (hm.containsKey(sum))
                return false;
            else {
                n = sum;
                hm.put(n, 1);
                sum = 0;
                digits = null;
            }
        }
    }

    private static List<Integer> getDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        int rem;
        while (n >= 1) {
            rem = n % 10;
            digits.add(rem);
            n = (n - rem) / 10;
        }
        return digits;
    }

}
