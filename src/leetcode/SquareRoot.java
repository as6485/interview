package leetcode;

public class SquareRoot {
    public static void main(String[] args) {
        int x = 2147395600;
        System.out.println(mySqrt(x));
    }

    private static int mySqrt(int x) {
        int sqrt = 0;
        if(x == 0)
            return 0;
        if(x == 1)
            return 1;
        for(int i = 1; i <= x/2; i++){
            if(i*i > x){
                System.out.println(i);
                break;
            }
            else {
                sqrt = i;
            }
        }

        return sqrt;
    }
}
