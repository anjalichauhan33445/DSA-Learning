import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second;
    int third;

    Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

public class Matrix01{

    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        int[][] visited = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    visited[i][j] = 1;
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            int steps = q.peek().third;
            q.remove();

            dist[r][c] = steps;

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    visited[nrow][ncol] != 1) {

                    visited[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, steps + 1));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Matrix01 obj = new Matrix01();

        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };

        int[][] result = obj.updateMatrix(grid);

        System.out.println("Distance matrix:");
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
