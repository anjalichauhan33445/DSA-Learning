import java.util.Arrays;

class SurroundedRegions {

    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};

    void dfs(int row, int col, int[][] visited, char[][] mat) {
        visited[row][col] = 1;

        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < m &&
                visited[nrow][ncol] != 1 &&
                mat[nrow][ncol] == 'O') {

                dfs(nrow, ncol, visited, mat);
            }
        }
    }

    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        for (int j = 0; j < m; j++) {

            if (visited[0][j] == 0 && grid[0][j] == 'O') {
                dfs(0, j, visited, grid);
            }

            if (visited[n - 1][j] == 0 && grid[n - 1][j] == 'O') {
                dfs(n - 1, j, visited, grid);
            }
        }

        for (int i = 0; i < n; i++) {

            if (visited[i][0] == 0 && grid[i][0] == 'O') {
                dfs(i, 0, visited, grid);
            }

            if (visited[i][m - 1] == 0 && grid[i][m - 1] == 'O') {
                dfs(i, m - 1, visited, grid);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (visited[i][j] == 0 && grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {

        char[][] grid = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        SurroundedRegions sol = new SurroundedRegions();

        System.out.println("Original Matrix:");
        printMatrix(grid);

        sol.solve(grid);

        System.out.println("\nMatrix After Solving:");
        printMatrix(grid);
    }

    static void printMatrix(char[][] grid) {
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}