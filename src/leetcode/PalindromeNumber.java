package leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(isPalindrome(x));
    }

    private static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        else{
            StringBuilder sb = new StringBuilder(String.valueOf(x));
            System.out.println("String : "+sb.toString());
            return sb.toString().equals(sb.reverse().toString());
        }
    }
}


