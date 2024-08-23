package leetcode;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
    private static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        /// UPVOTE !
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] charArr = s.toCharArray();

        while (end < charArr.length) {
            if (map[charArr[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[charArr[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? new String() :
                new String(charArr, startIndex, minLen);
    }

    /*private static String minWindow(String s, String t) {
        int left = 0, right = 0;
        int m = s.length(), n = t.length();
        String minSubstring = s;
        Character leftKey;
        if(m < n)
            return minSubstring;

        //frequency map
        HashMap<Character, Integer> map = new HashMap<>();
        t.chars().mapToObj(c -> (char) c).toList().forEach(c -> {
            map.put(c, map.getOrDefault(c, 0) + 1);
        });

        //sliding window
        while(right<m){
            Character key = s.charAt(right);
            Integer val = map.get(key);
            //not in t
            if(val == null){
                right++;
            }
            //this char is in t
            else if(val > 0){
                right++;
                //decrement the frequency
                map.put(key, val-1);
                //check if a valid substring
                Integer sum = map.values()
                        .stream()
                        .mapToInt(Integer::valueOf)
                        .sum();
                if(sum == 0){
                    //check if minSubstring
                    String subString = s.substring(left, right);
                    minSubstring = (subString.length() < minSubstring.length()) ? subString : minSubstring;
                    //Todo shrink here
                    leftKey = s.charAt(left);
                    if(map.containsKey(leftKey)){
                        //increment the frequency
                        map.put(leftKey, map.get(leftKey)+1);
                    }
                    while((left < m)){
                        left++;
                        if(map.get(s.charAt(left))!=null){
                            break;
                        }
                    }
                }
            }
            //this char with required freq is already part of the current window, but we have encountered it again
            else if(val == 0){
                //increment the frequency
                map.put(key, val+1);
                right++;
            }
        }

        //shrink here ADOBECODEBANC
        while((left < m)){
            leftKey = s.charAt(left);
            if(map.containsKey(leftKey)){
                //check if minSubstring
                String subString = s.substring(left, right);
                minSubstring = (subString.length() < minSubstring.length()) ? subString : minSubstring;

                if(map.values()
                        .stream()
                        .mapToInt(Integer::valueOf)
                        .sum() == 0)
                    break;

                //decrement the frequency
                map.put(leftKey, map.get(leftKey)-1);

            }
            while((left < m)){
                left++;
                if(map.get(s.charAt(left))!=null){
                    break;
                }
            }

        }

        return minSubstring;
    }*/
}
