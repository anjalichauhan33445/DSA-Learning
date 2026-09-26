import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementII {
    static  List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()>nums.length/3) ans.add(entry.getKey());
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println("Output: "+majorityElement(nums));
    }
}
