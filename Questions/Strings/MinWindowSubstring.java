import java.util.Arrays;

public class MinWindowSubstring {
    static String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        int l = 0;
        int r = 0;
        int ct = 0;
        int[] H = new int[256];
        Arrays.fill(H,0);
        for(int i = 0;i<t.length();i++){
            H[t.charAt(i)]++;
        }

        while(r<s.length()){
            H[s.charAt(r)]--;
            if(H[s.charAt(r)]>=0){
                ct++;
            }
            while(ct==t.length()){
                if((r-l+1)<minLen){
                    minLen = r-l+1;
                    sIndex = l;
                }
                H[s.charAt(l)]++;
                
                if(H[s.charAt(l)]>0) ct--;
                l++;
                
            }
            r++;
        }
        return sIndex==-1?"":s.substring(sIndex,sIndex+minLen);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Output: "+minWindow(s, t));
    }
}
