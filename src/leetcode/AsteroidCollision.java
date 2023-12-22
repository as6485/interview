package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AsteroidCollision {

    public static void main(String[] args) {
        int asteroids[] = new int[]{-2, 2, -1, -2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        List<Integer> arr = IntStream.of(asteroids).boxed().collect(Collectors.toList());
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < 0) {
                int j = i - 1;
                while (j >= 0 && arr.get(j) > 0) {
                    int initialArrSize = arr.size();
                    if (Math.abs(arr.get(j)) > Math.abs(arr.get(i))) {
                        arr.remove(i);
                        i -= (initialArrSize - arr.size());
                        break;
                    } else if (Math.abs(arr.get(j)) == Math.abs(arr.get(i))) {
                        arr.remove(i);
                        arr.remove(j);
                        i -= (initialArrSize - arr.size());
                        break;
                    } else {
                        arr.remove(j);
                        i -= (initialArrSize - arr.size());
                    }
                    j--;
                }
            }
        }

        return arr.stream().mapToInt(i -> i).toArray();
    }
}
