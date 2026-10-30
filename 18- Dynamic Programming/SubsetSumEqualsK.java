import java.util.Arrays;

public class SubsetSumEqualsK {
    static boolean fun(int i, int t, int[] nums, int[][] dp){
        if(t==0) return true;
        if(i==0) return nums[0]==t;
        
        if(dp[i][t]!=-1) return dp[i][t]==1;
        boolean npick = fun(i-1,t,nums,dp);

        boolean pick = false;
        if(t>=nums[i]) pick = fun(i-1,t-nums[i],nums,dp);
        
        dp[i][t] = npick || pick?1:0;
        return dp[i][t]==1;
    }
    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;
        int[][] dp = new int[nums.length][target+1];
        for(int[] arr: dp) Arrays.fill(arr,-1);
        
        System.out.println(fun(nums.length-1,target,nums,dp)); 
    }
}
