package leetcode;

public class ReverseBits {
    public static void main(String[] args) {
        int x = 4;
        System.out.println(reverseBits(x));
    }

    private static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans <<= 1;
            ans |= (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
