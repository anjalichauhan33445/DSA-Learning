// leetcode 724

class findPivot {
    static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = 0;
        for(int i = 1; i<prefix.length;i++){
            prefix[i] = prefix[i-1]+nums[i-1];
        }
        suffix[n-1] = 0;
        for(int i = n-2; i>=0; i--){
            suffix[i] = suffix[i+1]+nums[i+1];
        }

        for(int i = 0;i<nums.length; i++){
            if(prefix[i]==suffix[i]) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println("Output: "+pivotIndex(nums));
    }
}