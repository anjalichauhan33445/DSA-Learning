import java.util.Arrays;

class NumberOfEnclaves {

    int[] drow = { -1, 0, 1, 0 };
    int[] dcol = { 0, 1, 0, -1 };

    void dfs(int row, int col, int[][] visited, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        visited[row][col] = 1;

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    visited[nrow][ncol] != 1 &&
                    grid[nrow][ncol] == 1) {

                dfs(nrow, ncol, visited, grid);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        for (int j = 0; j < m; j++) {

            if (visited[0][j] == 0 && grid[0][j] == 1) {
                dfs(0, j, visited, grid);
            }

            if (visited[n - 1][j] == 0 && grid[n - 1][j] == 1) {
                dfs(n - 1, j, visited, grid);
            }
        }

        for (int i = 0; i < n; i++) {

            if (visited[i][0] == 0 && grid[i][0] == 1) {
                dfs(i, 0, visited, grid);
            }

            if (visited[i][m - 1] == 0 && grid[i][m - 1] == 1) {
                dfs(i, m - 1, visited, grid);
            }
        }

        int ct = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (visited[i][j] != 1 && grid[i][j] == 1) {
                    ct++;
                }
            }
        }

        return ct;
    }

    public static void main(String[] args) {

        int[][] grid = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 }
        };

        NumberOfEnclaves sol = new NumberOfEnclaves();

        System.out.println("Input Grid:");

        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        int result = sol.numEnclaves(grid);

        System.out.println("\nNumber of Enclaves: " + result);
    }
}