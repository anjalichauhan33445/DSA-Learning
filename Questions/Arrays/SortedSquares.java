import java.util.*;

class SortedSquares{
    static int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        int k = n-1;
        int j = n-1;
        int i = 0;
 

       while(i<=j){
            if(Math.abs(nums[j])>Math.abs(nums[i])){
                ans[k--] = nums[j]*nums[j];
                j--;
            }
            else{
                ans[k--] = nums[i]*nums[i];
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
        

    }
}