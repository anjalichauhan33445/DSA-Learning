import java.util.*;

class Solution {

    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};

    void dfs(int row, int col, int[][] visited, ArrayList<String> vec,
             char[][] grid, int row0, int col0) {

        int n = grid.length;
        int m = grid[0].length;

        visited[row][col] = 1;
        vec.add(toString(row - row0, col - col0));

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 'L') {
                dfs(nrow, ncol, visited, vec, grid, row0, col0);
            }
        }
    }

    String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    public int countDistinctIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 'L') {
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, visited, vec, grid, i, j);
                    set.add(vec);
                }
            }
        }

        return set.size();
    }
}

public class NumberOfDistinctIslands {
    public static void main(String[] args) {

        char[][] grid = {
            {'L', 'L', 'W', 'W', 'W'},
            {'L', 'W', 'W', 'L', 'L'},
            {'W', 'W', 'W', 'L', 'W'},
            {'L', 'L', 'W', 'W', 'W'}
        };

        Solution sol = new Solution();

        System.out.println(sol.countDistinctIslands(grid));
    }
}