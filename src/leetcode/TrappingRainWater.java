package leetcode;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    private static int trap(int[] h) {
        int l = 0, r = h.length - 1, lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE, ans = 0;
        while (l < r) {
            lmax = Math.max(lmax, h[l]);
            rmax = Math.max(rmax, h[r]);
            ans += (lmax < rmax) ? lmax - h[l++] : rmax - h[r--];
        }
        return ans;
    }

    /*private static int trap(int[] height) {
        int trap =0, leftBoundary = Integer.MIN_VALUE, rightBoundary = Integer.MIN_VALUE;
        leftBoundary = Math.max(leftBoundary, height[0]);
        if(height.length<3) return 0;

        for(int i = 1; i<=height.length-2; i++){
        //find left boundary
        leftBoundary = Math.max(leftBoundary, height[i-1]);

        //find right boundary
            for(int j=i+1; j<=height.length-1; j++){
                rightBoundary=Math.max(rightBoundary, height[j]);
            }
        //calculate water holding capacity of this column
            if(leftBoundary>height[i] && rightBoundary>height[i]){
                trap+=Math.min(leftBoundary, rightBoundary) - height[i];
            }

            rightBoundary=Integer.MIN_VALUE;
        }

        return trap;
    }*/
}
