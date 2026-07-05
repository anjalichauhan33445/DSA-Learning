import java.util.*;

class CharacterReplacement {
    static int foo(String s, int k) {
        int i = 0;
        int max_len = 0;
        int max_freq  = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int j = 0; j <s.length(); j++){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            max_freq = Math.max(max_freq,map.get(s.charAt(j)));

            while((j-i+1)-max_freq>k){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if (map.get(s.charAt(i)) == 0)
                    map.remove(s.charAt(i));
                i++;
            }
            max_len = Math.max(max_len,j-i+1);
        }
        return max_len;
    }
    public static void main(String[] args) {
        int k = 2;
        String s = "ABAB";
        System.out.println("The Length of Longest string obtained is: "+foo(s,k));
    }
}
