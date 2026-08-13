
import java.util.ArrayList;
import java.util.Stack;

class PrevSmaller {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i<arr.length;i++){
            while(!stk.isEmpty() && stk.peek()>=arr[i]){
                stk.pop();
            }
            if(stk.isEmpty()) ans.add(-1);
            else ans.add(stk.peek());
            stk.push(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]arr = {1, 6, 2};
        System.out.println("Output: "+prevSmaller(arr));
    }
}