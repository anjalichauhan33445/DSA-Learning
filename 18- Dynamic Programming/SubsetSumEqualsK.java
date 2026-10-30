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
        
        System.out.println("Memoization");
        System.out.println(fun(nums.length-1,target,nums,dp)); 

        System.out.println("Tabulation");
        tabulation(nums, target);
    }
    static void tabulation(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length][target+1];
        
        for(int i = 0; i<nums.length; i++) dp[i][0] = true;
        
        if(nums[0]<=target) dp[0][nums[0]] = true;
        
        for(int i = 1;i<nums.length; i++){
            for(int t = 1; t<=target; t++){
                boolean npick = dp[i-1][t];

                boolean pick = false;
                if(t>=nums[i]) pick = dp[i-1][t-nums[i]];
                
                dp[i][t] = pick || npick;
            }
        }
        
        System.out.println(dp[nums.length-1][target]); 
    }
}
