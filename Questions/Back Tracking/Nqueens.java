import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueens {
    static void solve(int col,List<List<String>> ans,char[][] board,int n,int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal){
        if(col==n){
            List<String> curr = new ArrayList<>();
            for(int i = 0;i<n;i++){
                curr.add(new String(board[i]));
            }
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int row = 0;row<n;row++){
            if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[n-1+col-row]==0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                upperDiagonal[n-1+col-row] = 1;
                lowerDiagonal[row+col] = 1;
                solve(col+1,ans,board,n,leftRow,lowerDiagonal,upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                upperDiagonal[n-1+col-row] = 0;
                lowerDiagonal[row+col] = 0;
            }

        }


    }
    static public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2*n-1];
        int[] upperDiagonal = new int[2*n-1];
        Arrays.fill(leftRow,0);
        Arrays.fill(lowerDiagonal,0);
        Arrays.fill(upperDiagonal,0);
        
        solve(0,ans,board,n,leftRow, lowerDiagonal, upperDiagonal);
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Output: "+solveNQueens(n));
    }
}
