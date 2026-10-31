public class MinDifference {
    public static void main(String[] args) {
        int[] nums = {1, 6, 11, 5};
        int n = nums.length;
        int sum  = 0;
        for(int num : nums) sum+=num;
        boolean[][] dp = new boolean[nums.length][sum+1];

        for(int i = 0; i<nums.length; i++){
            dp[i][0] = true;
        }

        if(nums[0]<=sum) dp[0][nums[0]] = true;
        for(int i = 1; i<nums.length; i++){
            for(int k = 1; k<=sum; k++){
                boolean npick = dp[i-1][k];
                boolean pick = false;

                if(k>=nums[i]) pick = dp[i-1][k-nums[i]];

                dp[i][k] = npick || pick;
            }
        }

        int mini = Integer.MAX_VALUE;


        for(int s1 = 0; s1<=sum/2; s1++){
            if(dp[n-1][s1]==true){
                mini = Math.min(mini,Math.abs((sum-s1)-s1));
            }
        }
        System.out.println(mini); 
    }
}
