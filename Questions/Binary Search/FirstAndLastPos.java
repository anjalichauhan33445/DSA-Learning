import java.util.Arrays;

public class FirstAndLastPos {
    static int[] searchRange(int[] nums, int target) {
        int first  = lowerBound(nums,target);
        int last = upperBound(nums,target)-1;
        if(first==nums.length || nums[first]!=target) return new int[] {-1,-1};
        return new int[] {first,last};
    }
    static int lowerBound(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>=target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    static int upperBound(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] ans = searchRange(nums, target);
        System.out.println("Output: "+Arrays.toString(ans));
    }

}


