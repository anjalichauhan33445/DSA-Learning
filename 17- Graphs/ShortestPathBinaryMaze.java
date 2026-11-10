import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int wt;
    int row;
    int col;

    Pair(int wt, int row, int col){
        this.wt = wt;
        this.row = row;
        this.col = col;
    }
}
public class ShortestPathBinaryMaze {
    static  int shortestPath(int[][] grid, int[] src, int[] dest) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[src[0]][src[1]] == 0 || grid[dest[0]][dest[1]] == 0)
            return -1;
        if(src[0]==dest[0] && src[1]==dest[1])
            return 0;

        int[][] dist = new int[n][m];
        for(int[] arr: dist) Arrays.fill(arr,(int)1e9);
        
        dist[src[0]][src[1]] = 0;
        
        Queue<Pair> q = new LinkedList<>();
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        q.add(new Pair(0,src[0],src[1]));
        while(!q.isEmpty()){
            int wt = q.peek().wt;
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            

            for(int i = 0; i<4; i++){
                int nrow = drow[i]+row;
                int ncol = dcol[i]+col;
                
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1 && dist[nrow][ncol]>wt+1){
                    dist[nrow][ncol] = wt+1;
                    if(nrow==dest[0] && ncol==dest[1]) return wt+1;
                    q.add(new Pair(dist[nrow][ncol],nrow,ncol));
                }
            }
        }
            return -1;
            
    }
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}, {1, 0, 0, 1}};
        int[] src = {0, 1};
        int[] dest = {2, 2};
        System.out.println(shortestPath(mat, src, dest));
    }
}
