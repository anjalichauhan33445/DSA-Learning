import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        subsets(0,nums,curr,ans);
        return ans;
    }
    static void subsets(int ind, int[] nums, List<Integer> curr, List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));
        for(int i = ind; i<nums.length;i++){
            if(i>ind && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            subsets(i+1,nums,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println("Output: "+subsetsWithDup(nums));
    }

}
