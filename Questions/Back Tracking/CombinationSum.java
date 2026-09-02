import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combination(0,target,curr,ans,candidates);
        return ans;
    }
    static void combination(int i,int target,List<Integer> curr,List<List<Integer>> ans,int[] nums){
        if(i==nums.length){
            if(target==0){
            ans.add(new ArrayList<>(curr));
            }
            return;
        }
        if(nums[i]<=target){
            curr.add(nums[i]);
            combination(i,target-nums[i],curr,ans,nums);
            curr.remove(curr.size()-1);
           
        }
        combination(i+1,target,curr,ans,nums);
        
    }
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println("Output: "+combinationSum(candidates, target));
    }
}
