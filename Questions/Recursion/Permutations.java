import java.util.ArrayList;
import java.util.List;

public class Permutations {
    static  List<List<Integer>> permute(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        permutation(0,nums,curr,ans);
        return ans;
    }

    static void permutation(int ind,int[] nums, List<Integer> curr, List<List<Integer>> ans){
        if(ind==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
 
        for(int i = ind; i<nums.length;i++){
            int temp = nums[i];
            nums[i] = nums[ind];
            nums[ind] = temp;
            curr.add(nums[ind]);
            permutation(ind+1,nums,curr,ans);
            curr.remove(curr.size()-1);
            temp = nums[i];
            nums[i] = nums[ind];
            nums[ind] = temp;
            
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println("Output: "+permute(nums));
    }
}
