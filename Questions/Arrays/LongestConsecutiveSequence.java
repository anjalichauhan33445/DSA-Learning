import java.util.Arrays;

public class LongestConsecutiveSequence {
    static int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int ct = 0;
        int maxm = 1;
        int prevSmall = Integer.MIN_VALUE;

        for(int i = 0; i<nums.length;i++){
            if(nums[i]-1==prevSmall){
                ct++;
                prevSmall = nums[i];
            }
            else if(prevSmall!=nums[i]){
                ct = 1;
                prevSmall = nums[i];
            }
            maxm = Math.max(maxm, ct);
        } 
        return maxm;
    }
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println("Output: "+longestConsecutive(nums));
    }
}
