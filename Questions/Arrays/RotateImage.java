import java.util.Arrays;

public class RotateImage {
    //brute force
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

    //optimal
    static  void rotate1(int[][] matrix){
        int n = matrix.length;

        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0;i<n;i++){
            reverse(matrix[i]);
        }
    }

    static  void reverse(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int[][] matrix =  {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Before Rotation: ");

        for(int i = 0; i<matrix.length;i++){
           System.out.println(Arrays.toString(matrix[i]));
        }

        rotate1(matrix);
        System.out.println("After Rotation: ");
        
        for(int i = 0; i<matrix.length;i++){
           System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
