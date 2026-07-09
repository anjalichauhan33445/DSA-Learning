// leetcode 560

import java.util.*;

class SubarraySum {
    static int subarraySum(int[] nums, int k) {
        int prefix_sum = 0;
        int ct =0 ;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i<nums.length; i++){
            prefix_sum+=nums[i];
            int need = prefix_sum-k;
            if(map.containsKey(need)){
                ct+=map.get(need);
            }
            map.put(prefix_sum,map.getOrDefault(prefix_sum,0)+1);
        }
        return ct;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println("Output: "+subarraySum(nums, k));
    }
}