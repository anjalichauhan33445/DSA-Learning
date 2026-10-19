import java.util.Arrays;

public class FrogJump {
    static int sol(int i , int[] height, int[] dp){
        if(i==0) return 0;
        
        if(dp[i]!=-1) return dp[i];
        int left = sol(i-1,height,dp) + Math.abs(height[i]-height[i-1]);
        int right = Integer.MAX_VALUE;
        if(i>1){
            right = sol(i-2,height,dp)+Math.abs(height[i]-height[i-2]);
        }
        
        return dp[i] = Math.min(left,right);
    }
    public static void main(String[] args) {
        int[] height = {20, 30, 40, 20};
        int n = height.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("Output: "+sol(n-1,height,dp));
        
    }
}
