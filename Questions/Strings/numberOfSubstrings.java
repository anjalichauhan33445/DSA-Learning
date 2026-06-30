// Given a string s consisting only of characters a, b and c.
// Return the number of substrings containing at least one occurrence of all these characters a, b and c.


class numberOfSubstrings {
        static int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int n = s.length();
        int count=0;
        int  i = 0;
        for(int j = 0; j<n; j++){
            freq[s.charAt(j)-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                count+= n-j;
                freq[s.charAt(i)-'a']--;
                i++;
            }

        
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println("The number of such substrings are : "+numberOfSubstrings(s));
    }
}