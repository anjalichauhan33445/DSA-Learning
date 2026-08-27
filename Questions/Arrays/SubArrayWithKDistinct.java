import java.util.HashMap;

public class SubArrayWithKDistinct {
    static int subarraysWithKDistinct(int[] nums, int k) {
        return (helper(nums,k)-helper(nums,k-1));
    }
    static int helper(int[] nums,int k){
        if(k<0) return 0;
        int l = 0;
        int r = 0;
        int ct = 0;
        int curr = 0;
        HashMap<Integer,Integer> map= new HashMap<>();
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l],map.getOrDefault(nums[l],0)-1);
                if(map.get(nums[l])==0) map.remove(nums[l]);
                l++;
            }
            ct=ct+(r-l+1);
            r++;
        }
        return ct;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println("Output: "+subarraysWithKDistinct(nums, k));
    }
}
