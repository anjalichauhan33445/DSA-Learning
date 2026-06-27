

// Brute Force approach
class MaxSubArrAvgI {
    public static void main(String[] args) {
        int[] arr = {1,12,-5,-6,50,3};
        int n = arr.length;
        int k = 4;
        double max_sum = 0;
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
        System.out.println(max_sum);
        
    }
}