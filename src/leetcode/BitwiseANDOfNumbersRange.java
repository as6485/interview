package leetcode;

public class BitwiseANDOfNumbersRange {
    public static void main(String[] args) {
        int left =5, right=7;
        System.out.println(rangeBitwiseAnd(left, right));

    }

    private static int rangeBitwiseAnd(int left, int right) {
        int result = left&right;
        if(result == 0)
            return 0;
        else{
            // To find the position of the most significant set bit
            int k = (int)(Math.log(result) / Math.log(2));

            // To return the value of the number
            // with set bit at k-th position
            return 1 << k;
        }
    }
}
