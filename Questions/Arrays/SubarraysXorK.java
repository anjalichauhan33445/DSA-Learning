//count number of subarrays with xor - k

import java.util.HashMap;
import java.util.Map;

public class SubarraysXorK {
    static  int subarrayXor(int arr[], int k) {
        // code here
        int ct = 0;
        int xor = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num: arr){
            xor^=num;
            int need = xor^k;
            if(map.containsKey(need)){
                ct+=map.get(need);
            }
            map.put(xor,map.getOrDefault(xor,0)+1);
        }
        return ct;
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println("Output: "+subarrayXor(arr, k));
    }
}
