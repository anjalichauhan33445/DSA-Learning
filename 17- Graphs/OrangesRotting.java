import java.util.*;

class Pair{
    int first;
    int second;
    int tm;

    Pair(int first, int second, int tm){
        this.first = first;
        this.second = second;
        this.tm = tm;
    }
}

public class OrangesRotting {
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        int ctFresh = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }

                if(grid[i][j] == 1)
                    ctFresh++;
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        int time = 0;
        int ct = 0;

        while(!q.isEmpty()){

            int r = q.peek().first;
            int c = q.peek().second;
            int t = q.peek().tm;

            time = Math.max(t, time);

            q.remove();

            for(int i = 0; i < 4; i++){

                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && nrow < n &&
                   ncol >= 0 && ncol < m &&
                   vis[nrow][ncol] == 0 &&
                   grid[nrow][ncol] == 1){

                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    ct++;
                }
            }
        }

        if(ct != ctFresh)
            return -1;

        return time;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int ans = orangesRotting(grid);

        System.out.println("Minimum time required: " + ans);
    }
}