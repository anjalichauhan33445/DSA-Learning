import java.util.Arrays;

class ReverseArray {
        static void iterative(int[] arr){
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

        static void recursion(int[] arr, int i, int j){
            if(i>j) return;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            recursion(arr, i+1, j-1);
        }
        public static void main(String[] args) {
            int[] arr = {10,20,30,40,50};
            iterative(arr);
            System.out.println(Arrays.toString(arr));
        }
}
