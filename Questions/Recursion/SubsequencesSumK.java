class SubsequencesSumK {
    static int numSubseq(int i,int[] nums, int target) {
        if(i==nums.length){
            if(target==0){
                return 1;
            }
            return 0;
        }
        
        return numSubseq(i+1, nums, target-nums[i])+ numSubseq(i+1, nums, target);
    }
    public static void main(String[] args) {
        int[] nums = {3,5,6,7};
        int target = 9;
        System.out.println("Output: "+numSubseq(0, nums, target));
       

    }
}