import java.util.*;
class MoveZeroes{
      static void moveZeroes(int[] nums) {
        // int i = 0;
        // int j = nums.length-1;
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

    
    public static void main(String[] args) {
        int[] nums = {12,0,0,3,12};
        //moveZeroes(nums);
        int j;
        for(j = 0; j<nums.length; j++){
            if(nums[j]==0) break; 
        }
        System.out.println(j);
        int x= -2;
        System.out.println(Math.abs(-3));

    }
}