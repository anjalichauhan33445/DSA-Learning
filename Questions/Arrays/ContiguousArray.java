import  java.util.*;

//leetcode 525

class ContiguousArray {
    static int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix_sum = 0;
        int max_len = 0;
        map.put(0,-1);

        for(int i = 0;i <nums.length; i++){
            if(nums[i]==0) nums[i] = -1;
            prefix_sum+=nums[i];
            if(map.containsKey(prefix_sum)){
                int index = map.get(prefix_sum);
                max_len = Math.max(max_len,i-index);
            }
            else{
            map.put(prefix_sum,i);
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1,1,0,0,0};
        System.out.println("Output: "+findMaxLength(nums));
    }
}