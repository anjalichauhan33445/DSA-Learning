public class MaxConsecutiveOnesIII {
    
    static int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zeroes = 0;

        while(r<nums.length){
            if(nums[r]==0) zeroes++;
            if(zeroes>k){
                if(nums[l]==0) zeroes--;
                l++;
            }
            if(zeroes<=k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println("Output: "+longestOnes(nums, k));
    }
    
}
