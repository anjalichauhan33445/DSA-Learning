

// Brute Force approach
class MaxSubArrAvgI {

    public static void main(String[] args){
        int[] arr = {1,12,-5,-6,50,3};
        int k = 4;
        double max_avg_sum = optimal(arr, k);
        System.out.println("The Maximum Average subarray is "+max_avg_sum);
        System.out.println("The Maximum Average subarray is "+bruteForce(arr, k));
    }
    static double bruteForce(int[] arr, int k) {
        
        int n = arr.length;
   
        if(n==1) {

            return (double)arr[0]/k;
            }
   
        double max_sum = Double.NEGATIVE_INFINITY;
        int j;
        for(int i = 0; i<=n-k; i++){
            j = i;
            double sum = 0;
            while(j<k+i){
                sum+=arr[j];
                j++;
            }
            max_sum = Math.max(max_sum,(double)sum/k);
            
            
        }
        return max_sum;
        
    }

    static double optimal(int[] arr, int k){
        int n = arr.length;
        
        int sum = 0;
        for(int i = 0; i<k; i++){
            sum+=arr[i];
        }
        int maxSum = sum;

        for(int i = 1; i<=n-k; i++){
            sum = sum-arr[i-1]+arr[i+k-1];
            maxSum = Math.max(maxSum,sum);
        }

        return (double)maxSum/k;
    }
}