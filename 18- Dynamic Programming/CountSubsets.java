import java.util.Arrays;

public class CountSubsets {
    static int fun(int i, int target, int[] arr,int[][] dp){
        
        if(i==0){
            if(target==0 && arr[0]==0) return 2;
            if(target==0|| arr[0]==target) return 1;
            
            return 0;
        }

        if(dp[i][target]!=-1) return dp[i][target];
        
        int npick = fun(i-1,target,arr,dp);
        int pick = 0;
        if(target>=arr[i]) pick += fun(i-1,target-arr[i],arr,dp);
        
        return dp[i][target] = npick+pick;
        
    }
    static int perfectSum(int[] arr, int target) {
        // code here
        int[][] dp = new int[arr.length][target+1];
        for(int[] it: dp) Arrays.fill(it,-1);
        return fun(arr.length-1, target,arr,dp);
        
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 10, 6, 8};
        int target = 10;
        System.out.println(perfectSum(arr, target));
    }
}
