public class MaxmimumSubarraySum {
    static  int maxSubArray(int[] nums) {
        int maxm = Integer.MIN_VALUE;
        int sum = 0;
        for(int num: nums){
            sum+=num;
            maxm = Math.max(sum,maxm);
            if(sum<0) sum = 0;
        }
        return maxm;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Output: "+maxSubArray(nums));
    }

}
