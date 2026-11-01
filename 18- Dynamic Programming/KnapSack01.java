import java.util.Arrays;

public class KnapSack01 {
    static int fun(int i, int W, int[] val, int[] wt, int[][] dp){
        if(i==0){
            if(W>=wt[0]) return val[0];
            else return 0;
        }
        if(dp[i][W]!=-1) return dp[i][W];
        
        int npick = fun(i-1,W,val,wt,dp);
        int pick = Integer.MIN_VALUE;
        
        if(W>=wt[i]) pick = val[i] + fun(i-1,W-wt[i],val,wt,dp);
        
        return dp[i][W] = Math.max(npick,pick);
    }
    static public int knapsack(int W, int val[], int wt[]) {
        
        int[][] dp = new int[val.length][W+1];
        for(int[] arr: dp) Arrays.fill(arr,-1);
        return fun(val.length-1,W,val,wt,dp);
        
    }
    public static void main(String[] args) {
        int W = 4;
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        //System.out.println(knapsack(W, val, wt));

        //tabulation

        int[][] dp = new int[val.length][W+1];
        
        for(int i = wt[0]; i<=W; i++){
            dp[0][i] = val[0];
        }
        
        for(int i = 1; i<val.length; i++){
            for(int j = 0; j<=W; j++){
                int npick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                
                if(j>=wt[i]) pick = val[i] + dp[i-1][j-wt[i]];
                
                dp[i][j] = Math.max(npick,pick);
            }
        }
        
        System.out.println(dp[val.length-1][W]);
        
    }
}
