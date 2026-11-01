import java.util.Arrays;

public class CoinChange {
    static int fun(int i, int target, int[] nums, int[][] dp){
        
        if(i==0){
            if(target%nums[i]==0) return target/nums[i];
            return (int)1e9;
        }
        if(dp[i][target]!=-1) return dp[i][target];

        int npick = 0 + fun(i-1,target,nums,dp);
        int pick = (int)1e9;

        if(nums[i]<=target) pick = 1+ fun(i,target-nums[i],nums,dp);

        return dp[i][target] = Math.min(npick,pick);

    }
    static public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr: dp) Arrays.fill(arr,-1);

        int ans = fun(coins.length-1, amount, coins, dp);
        return ans>=(int)1e9?-1:ans;
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }
}
