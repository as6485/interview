package leetcode;

public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aa", s2 = "ab", s3 = "abaa";
        System.out.println(isInterleave(s1, s2, s3));
    }

    private static boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() > s1.length() + s2.length())
            return false;

        if(s1.length() == 0 || s2.length() == 0)
            return s1.equals(s3) || s2.equals(s3);

        int i=0,j=0,k=0;

        while(i<s1.length() && j<s2.length() && k<s3.length()){
            if(s3.charAt(k) != s1.charAt(i) && s3.charAt(k) != s2.charAt(j)){
                return false;
            } else if (s3.charAt(k) == s1.charAt(i) && s3.charAt(k) != s2.charAt(j)) {
                k++;i++;
            } else if (s3.charAt(k) != s1.charAt(i) && s3.charAt(k) == s2.charAt(j)) {
                k++;j++;
            } else {
                return isInterleave(s1.substring(i+1), s2.substring(j), s3.substring(k+1))
                        || isInterleave(s1.substring(i), s2.substring(j+1), s3.substring(k+1));
            }
        }
        if(k==s3.length()-1)
            return true;
        else {
            if(i < s1.length()-1){
                return s1.substring(i).equals(s3.substring(k));
            } else {
                return s1.substring(j).equals(s3.substring(k));
            }
        }
    }

}
