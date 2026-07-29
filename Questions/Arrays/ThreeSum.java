
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class ThreeSum{
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set= new HashSet<>(); 
        for(int i = 0;i<nums.length;i++){
            int j = i+1;
            int k = nums.length-1;
            
            
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){    
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                    if(set.add(temp)){
                        ans.add(temp);
                    }
                                                           
                    j++;
                    k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    k--;
                }
            }
            
        }
        System.out.println(ans);
    }
}