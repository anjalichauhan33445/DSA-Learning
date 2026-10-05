import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class NumberOfIslands {

    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};

    void bfs(int row, int col, char[][] grid, int[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        visited[row][col] = 1;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        while (!q.isEmpty()) {
            int ro = q.peek().first;
            int co = q.peek().second;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = ro + drow[i];
                int ncol = co + dcol[i];

                if (nrow >= 0 && nrow < n
                        && ncol >= 0 && ncol < m
                        && visited[nrow][ncol] == 0
                        && grid[nrow][ncol] == '1') {

                    visited[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ct = 0;

        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    ct++;
                    bfs(i, j, grid, visited);
                }
            }
        }

        return ct;
    }

    public static void main(String[] args) {

        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        NumberOfIslands obj = new NumberOfIslands();

        int ans = obj.numIslands(grid);

        System.out.println("Number of Islands: " + ans);
    }
}