import java.util.*;

public class FloodFill {

    static int[] drow = {-1, 0, 1, 0};
    static int[] dcol = {0, 1, 0, -1};

    static void dfs(int sr, int sc, int[][] image, int[][] ans, int newColor, int iniColor){

        ans[sr][sc] = newColor;

        int n = image.length;
        int m = image[0].length;

        for(int i = 0; i < 4; i++){

            int nrow = sr + drow[i];
            int ncol = sc + dcol[i];

            if(nrow >= 0 && nrow < n &&
               ncol >= 0 && ncol < m &&
               image[nrow][ncol] == iniColor &&
               ans[nrow][ncol] != newColor){

                dfs(nrow, ncol, image, ans, newColor, iniColor);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor){

        int iniColor = image[sr][sc];

        int[][] ans = image;

        dfs(sr, sc, image, ans, newColor, iniColor);

        return ans;
    }

    public static void main(String[] args){

        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] ans = floodFill(image, sr, sc, newColor);

        System.out.println("Flood Filled Image:");

        for(int i = 0; i < ans.length; i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}