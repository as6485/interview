package leetcode;

public class MinimumFlips {

    public static void main(String[] args) {
        System.out.println(minFlips(10,9, 1));
    }

    public static int minFlips(int a, int b, int c) {
        int bitPos = 0;
        int flips = 0;
        double length = Math.ceil(Math.log(Math.max(Math.max(a,b),c))/Math.log(2));
        System.out.println("length : "+ length);

        for(bitPos = 0; bitPos <= length; bitPos++){
            if(getBit(c,bitPos) == 0){
                if(getBit(a,bitPos) == 1 ){
                    flips++;
                }
                if(getBit(b,bitPos) == 1 ){
                    flips++;
                }
            }
            else{
                if(getBit(a,bitPos) != 1 && getBit(b,bitPos) != 1){
                    flips++;
                }
            }
        }
        return flips;
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
