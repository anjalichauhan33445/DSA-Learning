import java.util.*;
class MoveZeroes{
      static void bruteForce(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=0) list.add(nums[i]);
        }
        System.out.println(list);
        System.out.println(list.size());

        for(int  i =0; i<list.size(); i++){
            nums[i] = list.get(i);
        }
        for(int i = list.size(); i<nums.length; i++){
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
        
    }
    static void optimal(int[] nums){
        int n = nums.length;
        int zero = -1;

        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0){
                zero = i;
                break;
            }
        }
        if(zero==-1) return;
        int j = zero;
        for(int i = j+1; i<nums.length; i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    
    public static void main(String[] args) {
        int[] nums = {12,0,0,3,12};
        //bruteForce(nums);
        optimal(nums);
    

    }
}