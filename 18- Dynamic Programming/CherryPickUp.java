import java.util.Arrays;

public class CherryPickUp {
    static int fun(int i, int j1, int j2, int[][] grid, int[][][] dp){
        int n = grid.length;
        int m = grid[0].length;
        if(j1<0 || j1>m-1 || j2<0 || j2>m-1) return Integer.MIN_VALUE;
        if(i==n-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int maxm = Integer.MIN_VALUE;
        for(int di = -1; di<=1; di++){
            for(int dj = -1; dj<=1; dj++){
                if(j1==j2){
                   maxm = Math.max(maxm,grid[i][j1]+fun(i+1,j1+di,j2+dj,grid,dp));
                }
                else maxm = Math.max(maxm,grid[i][j1]+ grid[i][j2] + fun(i+1,j1+di,j2+dj,grid,dp));
            }
        }
        return dp[i][j1][j2] = maxm;
    }
    public static void main(String[] args) {
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];


        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                Arrays.fill(dp[i][j],-1);
            }

        }
        System.out.println(fun(0,0,m-1,grid,dp));
         
    }
}
