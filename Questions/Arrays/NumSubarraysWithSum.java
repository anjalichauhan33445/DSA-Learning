class NumSubarraysWithSum{
    static int numSubarraysWithSum(int[] nums, int goal) {
     return atMost(nums,goal)-atMost(nums,goal-1); 
    }
    static int atMost(int[] nums, int goal){
        int i = 0;
        int ct = 0;
        int sum = 0;

        for(int j = 0; j<nums.length; j++){
           if(goal < 0) return 0;
           sum+=nums[j];
            while(sum>goal){
                sum-=nums[i];
                i++;
            }
            ct+= j-i+1;
        }
        return ct;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println("Output: "+numSubarraysWithSum(nums,goal));
    }
}