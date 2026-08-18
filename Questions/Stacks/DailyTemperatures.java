import java.util.Arrays;
import java.util.Stack;

class DailyTemperatures {
    static int[] dailyTemperatures(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i = arr.length-1; i>=0;i--){
            while(!stk.isEmpty() && arr[stk.peek()]<=arr[i]){               
                stk.pop();
                }
            if(!stk.isEmpty()){
                ans[i] = stk.peek()-i;
            }
            stk.push(i);


        }
        return ans;
    }
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println("Output: "+Arrays.toString(dailyTemperatures(temperatures)));
    }
}