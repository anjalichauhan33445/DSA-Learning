public class CheckPalindrome {
    static boolean recursion(String s, int i, int n){
        if(i>=n/2) return true;
        
        if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        return recursion(s, i+1, n);

    }
    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(recursion(s, 0, 7));
    }
}
