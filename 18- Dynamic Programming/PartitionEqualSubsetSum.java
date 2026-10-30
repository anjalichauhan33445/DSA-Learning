import java.util.Arrays;

public class PartitionEqualSubsetSum {
    static boolean fun(int i, int target, int[] nums, int[][] dp){
        if(target==0) return true;
        if(i==0) return(nums[0]==target);

        if(dp[i][target]!=-1) return dp[i][target]==1;
        boolean npick = fun(i-1,target,nums,dp);
        boolean pick = false;
        if(target>=nums[i]) pick = fun(i-1,target-nums[i],nums,dp);

        dp[i][target] = npick ||pick?1:0;
        return dp[i][target]==1;

    }
    static public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum+=num;
        if((sum & 1)==1) return false;
        int[][] dp = new int[nums.length][sum+1];
        for(int[] arr: dp) Arrays.fill(arr,-1);
        return fun(nums.length-1,sum/2,nums,dp);
    }
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
}
