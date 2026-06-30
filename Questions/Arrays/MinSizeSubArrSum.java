

class MinSizeSubArrSum{
    static int bruteForce(int[] arr, int target) {
        int n = arr.length;
        int min_length = Integer.MAX_VALUE;
        
        for(int i = 0; i<n; i++){
            int sum = 0;
            for(int j = i; j<n; j++){
                sum+=arr[j];
                if(sum>=target){
                min_length = Math.min(j-i+1,min_length);
                break;
                
                }
                
            }
        }
        return min_length == Integer.MAX_VALUE?0:min_length;
    }

    static int optimal(int[] arr, int target) {
        int sum = 0;
        int min_len = Integer.MAX_VALUE;
        int i = 0;
        for(int j = 0; j<arr.length; j++){
            sum+=arr[j];
            while(sum>=target){
                min_len = Math.min(min_len, j-i+1);
                sum-=arr[i];
                i++;
            }
           
        }
        return min_len==Integer.MAX_VALUE?0:min_len;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        //System.out.println(bruteForce(arr,7));
        System.out.println(optimal(arr, 7));
    }
}