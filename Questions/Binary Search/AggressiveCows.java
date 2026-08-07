import java.util.Arrays;

class AggressiveCows {
    static int aggressiveCows(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int low = 1;
        int n = arr.length;
        int high = arr[n-1]-arr[0];
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(arr,mid,k)){
                low = mid+1;
            }
            else high = mid-1;
        }
        return high;
        
    }
    static boolean isPossible(int[] arr, int dist, int max_cows){
        int cow_ct = 1;
        int last = arr[0];
        
        for(int i =1; i<arr.length;i++){
            if(arr[i]-last>=dist){
                cow_ct++;
                last = arr[i];
            }
            
        }
        if(cow_ct>=max_cows) return true;
        return false;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 4, 8, 9};
        int k = 3;
        System.out.println("Output: "+aggressiveCows(arr,k));
    }
}