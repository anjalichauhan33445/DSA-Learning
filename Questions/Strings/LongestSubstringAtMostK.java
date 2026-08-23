import java.util.HashMap;

class LongestSubstringAtMostK{
    static int kDistinctChar(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0;
        int r = 0;
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()>k){
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                if(map.get(s.charAt(l))==0) map.remove(s.charAt(l));
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "aababbcaacc";
        int k = 2;
        System.out.println("Output: "+kDistinctChar(s, k));
    }
}