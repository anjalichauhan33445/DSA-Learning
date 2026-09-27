import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MergeIntervals {
    static int[][] merge(int[][] nums) {
        Arrays.sort(nums,(a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> ans = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(ans.isEmpty() || nums[i][0]>ans.get(ans.size()-1)[1]){
                ans.add(nums[i]);
            } 
            else{
                int el = Math.max(ans.get(ans.size()-1)[1],nums[i][1]);
                ans.get(ans.size()-1)[1] = el;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = merge(intervals);
        for(int i = 0;i<ans.length;i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
