package leetcode;

public class AddBinary {

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }

    /*private static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length()-1, lenB = b.length()-1;
        int carry = 0;
        while(lenA >= 0 || lenB >=0 ){
            if(a.charAt(lenA) == 0 && b.charAt(lenB) == 0 ){
                sb.append(String.valueOf(carry));
                carry = 0;
            } else if (a.charAt(lenA) != b.charAt(lenB) ) {
                carry+=1;
                if(carry == 1){
                    sb.append(String.valueOf(carry));
                    carry = 0;
                }
                else {
                    sb.append("0");
                    carry = 1;
                }
            }else if(a.charAt(lenA) == 1 && b.charAt(lenB) == 1 ){
                carry+=2;
                if(carry == 2){
                    sb.append("0");
                    carry = 1;
                }
                else if(carry == 3){
                    sb.append("1");
                    carry = 1;
                }
            }
            lenA--;
            lenB--;
        }

        return sb.reverse().toString();
    }*/
}
