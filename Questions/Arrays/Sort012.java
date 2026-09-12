import java.util.Arrays;

public class Sort012 {
    static  void sort012(int[] arr) {
        // code here
        int low = 0;
        int mid = 0;
        int n = arr.length;
        int high = n-1;
        
        while(mid<=high){
            if(arr[mid]==0){
                int temp = arr[mid];
                arr[mid++] = arr[low];
                arr[low++] = temp;
                
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        sort012(arr);
        System.out.println("After Sorting: "+Arrays.toString(arr));
    }
}
