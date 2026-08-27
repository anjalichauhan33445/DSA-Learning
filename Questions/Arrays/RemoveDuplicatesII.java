
class RemoveDuplicatesII{
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println("Output: "+removeDuplicates(nums));
    }
   
    static int removeDuplicates(int[] nums) {
        int i = 0;
        for(int num: nums){
            if(i==0 || i==1 || num!=nums[i-2]){
                nums[i] = num;
                i++;
            }
        }
        return i;
        
    }
}