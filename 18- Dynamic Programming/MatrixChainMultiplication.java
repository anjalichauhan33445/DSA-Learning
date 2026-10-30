import java.util.Arrays;

public class MatrixChainMultiplication {
    static  void mcm(int[] d,int n){
        int[][] M = new int[n+1][n+1];
        int[][] K = new int[n+1][n+1];

        for(int diff = 1;diff<n;diff++){
            for(int i = 1; i<=n-diff;i++){
                int j = diff+i;

                M[i][j] = Integer.MAX_VALUE;

                for(int k = i;k<j;k++){
                    int cost = M[i][k]+M[k+1][j]+(d[i-1]*d[k]*d[j]);
                    if(cost<M[i][j]){
                        M[i][j] = cost;
                        K[i][j] = k;
                    }
                }
            }
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1; j<=n; j++){
                if(i>j){
                    System.out.print("-\t");
                }
                else{
                    System.out.print(M[i][j]+"\t");
                }
            }
            System.out.println();
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1; j<=n; j++){
                if(i>j){
                    System.out.print("-\t");
                }
                else{
                    System.out.print(K[i][j]+"\t");
                }
            }
            System.out.println();
        }
        

    }
    public static void main(String[] args) {
        int[] d = {5,6,2,4,3};
        int n = 4;

        mcm(d,n);
    }
}
