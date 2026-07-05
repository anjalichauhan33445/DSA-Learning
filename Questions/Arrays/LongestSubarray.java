// LeetCode: 1493

class LongestSubarray {
    static int longestSubarray(int[] nums) {
        int ct = 0;
        int i = 0;
        int max_len = 0;
        for(int j = 0; j<nums.length; j++){
            if(nums[j]==0) ct++;
            while(ct>1){
                if(nums[i]==0) ct--;
                i++;
            }
            max_len = Math.max(j-i,max_len);
        }
        return max_len;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        System.out.println("The Longest such Subarray is : "+longestSubarray(nums));
    }
}