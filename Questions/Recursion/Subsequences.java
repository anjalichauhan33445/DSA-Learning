import java.util.ArrayList;
import java.util.List;

public class Subsequences {
    static void printSubsequence(int[] arr, int i,List<Integer> curr, List<List<Integer>> ans){
    
        if(i==arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(arr[i]);
        printSubsequence(arr, i+1,curr, ans);
        curr.remove(curr.size()-1);
        printSubsequence(arr, i+1,curr, ans);
    }
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        List<List<Integer>> ans = new ArrayList<>();
        printSubsequence(arr, 0,new ArrayList<>(), ans);
        System.out.println("Output: "+ans);
    }
}
