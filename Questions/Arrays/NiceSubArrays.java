public class NiceSubArrays {
    static int numberOfSubarrays(int[] nums, int k) {
       return (helper(nums,k)-helper(nums,k-1));
    }
    static int helper(int[] nums, int k){
        if(k<0) return 0; 
        int l = 0;
        int r = 0;
        int oddCt = 0;
        int ct = 0;
        while(r<nums.length){
            if(nums[r]%2!=0) oddCt++;
            while(oddCt>k){
                if(nums[l]%2!=0) oddCt--;
                l++;
            }
            ct = ct+(r-l+1);
            r++;
        }
        return ct;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println("Output: "+numberOfSubarrays(nums, k));
    }
}
