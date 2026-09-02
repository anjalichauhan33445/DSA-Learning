
import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combination(1,ans,curr,k,n);
        return ans;
    }
    static void combination(int i, List<List<Integer>> ans, List<Integer> curr,int k, int n){
        if(k==0){
            if(n==0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        for(int j = i;j<=9;j++){
            //if(j>n) break;
            curr.add(j);
            combination(j+1,ans,curr,k-1,n-j);
            curr.remove(curr.size()-1);

        }
    }
    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println("Output: "+combinationSum3(k, n));
    }

}
