import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementII {
    static  List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        int ct1 = 0;
        int ct2 = 0;

        for(int num: nums){
            if(ct1==0 && el2!=num){
                el1 = num;
                ct1 = 1;
            }
            else if(ct2==0 && el1!=num){
                el2 = num;
                ct2 = 1;
            }
            else if(num==el1) ct1++;
            else if(num==el2) ct2++;
            else{
                ct1--;
                ct2--;
            }
        }
        ct1 = 0;
        ct2 = 0;
        for(int num: nums){
            if(num==el1) ct1++;
            else if(num==el2) ct2++;
        }
        int minm = nums.length/3+1;
        if(ct1>=minm) ans.add(el1);
        if(ct2>=minm) ans.add(el2);
        Collections.sort(ans);
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println("Output: "+majorityElement(nums));
    }
}
