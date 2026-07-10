//leetcode 523
import java.util.*;
class CheckSubarraySum {
    static  boolean checkSubarraySum(int[] nums, int k) {
    
        int prefix_sum = 0;
        int len;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i<nums.length; i++){
            prefix_sum+=nums[i];
            int remainder = prefix_sum % k;
            if(map.containsKey(remainder)){
                len = i - map.get(remainder);
                if(len>=2){
                    return true;
                }
            }
            else{
            map.put(remainder,i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        System.out.println("Output: "+checkSubarraySum(nums, k));
    }
}