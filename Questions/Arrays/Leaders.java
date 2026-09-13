import java.util.ArrayList;
import java.util.Collections;

public class Leaders {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int maxm = Integer.MIN_VALUE;
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i]>=maxm){
                maxm = arr[i];
                ans.add(arr[i]);
            }
        }
        Collections.reverse(ans);
        return ans;
        
    }
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println("Output: "+leaders(arr));
    }
}
