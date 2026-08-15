//lc 907
import java.util.Stack;

public class SumSubarrayMin {
    static int sumSubarrayMins(int[] arr) {
        long total = 0;
        int mod = (int)(1e9+7);
        int[] nsE = nse(arr);
        int[] psEE = psee(arr);

        for(int i = 0;i<arr.length;i++){
            int left = i-psEE[i];
            int right = nsE[i]-i;
            total = (total+(left*right*1L*arr[i])%mod)%mod;

        }return (int)total;
       
    }
    static int[] nse(int[] arr){
        int n = arr.length;
        int[] nse = new int[arr.length];
        Stack<Integer> stk = new Stack<>();

        for(int i = arr.length-1;i>=0;i--){
            while(!stk.isEmpty() && arr[stk.peek()]>=arr[i]){
                stk.pop();
            }
            nse[i] = stk.isEmpty()?n:stk.peek();
            stk.push(i);
        }
        return nse;
    }

    static int[] psee(int[] arr){
        int n = arr.length;
        int[] psee = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i<arr.length;i++){
            while(!stk.isEmpty() && arr[stk.peek()]>arr[i]){
                stk.pop();
            }
            psee[i] = stk.isEmpty()?-1:stk.peek();
            stk.push(i);

        }
        return psee;

    }
    public static void main(String[] args) {
        int[] arr = {11,81,94,43,3};
        System.out.println("Output: "+sumSubarrayMins(arr));
    }
} 