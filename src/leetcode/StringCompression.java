package leetcode;

public class StringCompression {

    public static void main(String[] args) {
        String str = "abcccccccccccc";
        System.out.println(compress(str.toCharArray()));
    }

    public static int compress(char[] chars) {
        if(chars.length == 0)
            return 0;
        StringBuilder sb = new StringBuilder();
        char c = chars[0];
        int count = 1;
        for(int i=0; i<chars.length; i++){
            //equal
            if(i+1 < chars.length && c == chars[i+1]){
                count++;
            }
            //not equal
            else{
                sb.append(c);
                if(count > 1)
                    sb.append(count);
                if(i+1 < chars.length){
                    c = chars[i+1];
                    count = 1;
                }
            }
        }
        chars = sb.toString().toCharArray();
        System.out.println(chars);
        return chars.length;
    }
}
