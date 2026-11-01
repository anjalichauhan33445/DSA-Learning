import java.util.Arrays;

public class CountPartitions {
    static int fun(int i, int[] arr,int sum, int[][] dp){
        
        if(i==0){
            if(sum==0 && arr[0]==0) return 2;
            if(sum==0 || arr[0]==sum) return 1;
            return 0;
        }
        if(dp[i][sum]!=-1) return dp[i][sum];
        
        int npick =  fun(i-1,arr,sum,dp);
        int pick = 0;
        if(sum>=arr[i]) pick += fun(i-1,arr,sum-arr[i],dp);
        
        return dp[i][sum]  = pick+npick;
    }
    static public int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        
        for(int num: arr) totalSum+=num;
        
        if(totalSum-diff<0) return 0;
        if((totalSum-diff)%2!=0) return 0;
        
        int target = (totalSum-diff)/2;
        
        int[][] dp = new int[arr.length][target+1];
        
        for(int[] it: dp) Arrays.fill(it,-1);
        return fun(arr.length-1,arr,target,dp);    
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        int diff = 3;
        System.out.println(countPartitions(arr, diff));
    }
}
