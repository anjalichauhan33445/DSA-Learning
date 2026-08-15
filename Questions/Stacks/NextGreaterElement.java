//lc 496

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class NextGreaterElement{
    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
       HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];
        Stack<Integer> stk = new Stack<>();
        
        for(int i = nums2.length-1; i>=0;i--){
            while(!stk.isEmpty() && nums2[i]>=stk.peek()){
                stk.pop();
            }
            if(stk.isEmpty()){
                map.put(nums2[i],-1);
            }
            else if(nums2[i]<stk.peek()){
                map.put(nums2[i],stk.peek());
            }
            stk.push(nums2[i]);
        }
        for(int i = 0;i<ans.length;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println("Output"+Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}