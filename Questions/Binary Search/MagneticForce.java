import java.util.Arrays;

class MagneticForce{
    static int maxDistance(int[] position, int m) {
        return helper(position,m);
    }
    static int helper(int[] arr, int k) {
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
    static boolean isPossible(int[] arr, int dist, int maxm){
        int ct = 1;
        int last = arr[0];
        
        for(int i =1; i<arr.length;i++){
            if(arr[i]-last>=dist){
                ct++;
                last = arr[i];
            }
            
        }
        if(ct>=maxm) return true;
        return false;
    }
    public static void main(String[] args){
        int[] position = {1,2,3,4,7};
        int m = 3;
        System.out.println("Output: "+maxDistance(position,m));
        
    }
}