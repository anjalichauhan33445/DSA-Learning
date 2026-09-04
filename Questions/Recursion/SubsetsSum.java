import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsSum {
    static  ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        subSum(0,arr,0,ans);
        return ans;
    }
    
    static  void subSum(int i, int[] arr, int sum, ArrayList<Integer> ans){
        if(i==arr.length){
            ans.add(sum);
            return;
        }
        
        subSum(i+1,arr,sum+arr[i],ans);
        subSum(i+1,arr,sum,ans);
        
    }
    public static void main(String[] args) {
        int[] arr = {5, 6, 7};
        System.out.println("Output: "+subsetSums(arr));
    }
}
