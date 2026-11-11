import java.util.Arrays;
import java.util.PriorityQueue;

class Pair{
    int diff;
    int row;
    int col;

    Pair(int diff, int row, int col){
        this.diff = diff;
        this.row = row;
        this.col = col;
    }
}
class MinEffortPath{
    static  int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for(int[] arr: dist) Arrays.fill(arr,(int)1e9);

        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x,y)->x.diff-y.diff);
        q.add(new Pair(0,0,0));
        int[] drow ={-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int diff = q.peek().diff;
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            if(row==n-1 && col==m-1) return diff;
            for(int i = 0; i<4; i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int effort = Math.max(Math.abs(heights[nrow][ncol]-heights[row][col]),diff);
                    if(dist[nrow][ncol]>effort){
                        dist[nrow][ncol] = effort;
                        q.add(new Pair(effort,nrow,ncol));
                    }
                    
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[][] heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(minimumEffortPath(heights));
    }
}