import java.util.Arrays;

public class RotateImage {
    static  void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];

        for(int i  = 0; i<n; i++){
            for(int j = 0;j<n;j++){
                ans[j][n-1-i] = matrix[i][j];
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = ans[i][j];
            }
        }

    }
    public static void main(String[] args) {
        int[][] matrix =  {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Before Rotation: ");

        for(int i = 0; i<matrix.length;i++){
           System.out.println(Arrays.toString(matrix[i]));
        }

        rotate(matrix);
         System.out.println("After Rotation: ");
        
        for(int i = 0; i<matrix.length;i++){
           System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
