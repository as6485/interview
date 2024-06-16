package leetcode;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
    private static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        char[] arr = s.toLowerCase().toCharArray();
        int i=0, j=s.length()-1;
        while(i<=j){
            if(arr[i]!=arr[j]){
               return false;
            }
            i++;
            j--;
        }

        return true;
    }


}
