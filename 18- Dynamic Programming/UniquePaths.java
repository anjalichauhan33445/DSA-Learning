import java.util.Arrays;

public class UniquePaths {
    static int fun(int i, int j, int[][] dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int up = fun(i-1,j,dp);
        int left = fun(i,j-1,dp);
        return dp[i][j] = up+left;
    }
    static  int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(m-1,n-1,dp);
    }
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m,n));
    }
}
