package leetcode;

public class Candy {
    public static void main(String[] args)
    {
        int ratings[] = {1,2,87,87,87,2,1};
        System.out.println(candy(ratings));
    }

    private static int candy(int[] ratings) {
        int count = ratings.length;
        int left, right;

        for(int i = 0; i<ratings.length; i++){
            left = Integer.MAX_VALUE;
            right = Integer.MAX_VALUE;

            if(i-1 >= 0){
                left = ratings[i-1];
            }

            if(i+1 < ratings.length){
                right = ratings[i+1];
            }

            if(ratings[i] > left ){
                count+=(left+1);
            }

            if(ratings[i] > right ){
                count+=(right+1);
            }

        }

        return count;
    }
}
