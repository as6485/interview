package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountingBits {

    public static void main(String[] args) {
        /*List<Integer> boxedInts = IntStream.of(countBits(5)).boxed().collect(Collectors.toList());
        boxedInts.forEach(System.out::println);*/
        int n = 5;
        int result[] = countBits(n);
        for(int i =0; i<=n; i++){
            System.out.println("Number of 1s in "+i+ " is "+ result[i]);
        }
    }

    /*When it comes to even numbers, i.e, 2,4,6,8, their binary should be like '10', '100', '110', '1000' so one notable difference is their unit digit is always 0, which means when you call >> 1- shift one bit rightwards and also means dividing by 2- would cause no change to the count of '1' in the binary string.
    Vice versa, when you meet odd numbers, shifting one bit rightwards always eliminates one '1' digit from original binary string, that is why we should "compensate" one '1' character to the count.
    To sum up, when you meet even number the count of '1's is always the same as its half number, on the other hand, remember to plus one to the odds' half number.*/
    private static int[] countBits(int num) {
        int[] arr = new int[num + 1];
        int add = 0;
        for (int i=1; i<=num; i++) {
            add = i & 1;
            arr[i] = arr[i >> 1] + add;
        }
        return arr;
    }
    /*public static int[] countBits(int n) {
        int[] arr = new int[n+1];

        for(int i =0; i<=n; i++){
            int number = i;
            int counter = 0;
            while(number!=0){
                if((number&1) == 1 ){
                    counter++;
                }
                number = number >>> 1;
            }
            arr[i]=counter;
        }

        return arr;
    }*/


}
