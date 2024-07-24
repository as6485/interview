package leetcode;

public class HammingWeight {
    public static void main(String[] args) {
        int x = 11;
        System.out.println(hammingWeight(x));
    }

    private static int hammingWeight(int n) {
        int result = 0;
        for(int i = 0; i< 32; i++){
            result+=getBit(n, i);
        }
        return result;
    }

    private static int getBit(int num, int bit) {
        int bitMask = 1 << bit;
        if ((num & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
