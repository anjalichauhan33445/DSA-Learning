

class MinSizeSubArrSum{
    static int minSubArrayLen(int[] arr, int target) {
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
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(arr,7));
    }
}