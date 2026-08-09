public class FindFloor {
   
    static int findFloor(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]<=x){
                low = mid+1;
            }
            else{
                high = mid-1;
            }            
        }
        return high;
        
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;
        System.out.println("Output: "+findFloor(arr, x));
    }

}
