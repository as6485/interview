package leetcode;

public class GuessNumberHigherorLower {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(guessNumber(n));
    }

    public static int guessNumber(int n) {
        long start=1, end=n, mid;
        while( start<=end){

            mid= (start+end)/2;

            if( guess((int)mid)==0) return (int)mid;
            else if( guess((int)mid)==1) start=mid+1;
            else end=mid-1;
        }

        return -1;
    }

    public static int guess(int n) {
        int pick = 6;
        if(n>pick)
            return -1;
        else if (n < pick)
            return 1;
        else
            return 0;
    }
}
