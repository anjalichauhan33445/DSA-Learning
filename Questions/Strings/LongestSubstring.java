import java.util.*;

class LongestSubstring {
        static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int max_len = 0;
        int i = 0;
        int j = 0;
        while(j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                max_len = Math.max(max_len,j-i+1);
                j++;
            }
            else{
                set.remove(s.charAt(i));
                i++;
               
            }
            
        }
        return max_len;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int maxl = lengthOfLongestSubstring(s);
        System.err.println(maxl);
    }
}