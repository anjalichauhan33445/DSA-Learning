import java.util.*;
class ContainsDuplicate {
    static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i<nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        if(containsDuplicate(nums)){
            System.out.println("The array contains duplicate");
        }
        else{
            System.out.println("The array doesn't contain duplicate");
        }
    }
    
}