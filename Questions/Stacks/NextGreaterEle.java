
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterEle {
    static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>();

        for(int i = 2*n-1; i>=0;i--){
            while(!stk.isEmpty()&& nums[i%n]>=stk.peek()){
                stk.pop();
            }
            if(i<n){
                ans[i] = stk.isEmpty()?-1:stk.peek();
            }
            stk.push(nums[i%n]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums ={1,2,1};
        System.out.println("Output: "+Arrays.toString(nextGreaterElements(nums)));
    }
}
