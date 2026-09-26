import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementII {
    static  List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int minm = (nums.length/3)+1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)==minm) ans.add(num);
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println("Output: "+majorityElement(nums));
    }
}
