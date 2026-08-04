class MakeMBouquets {
    static int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<((long)m*k)) return -1;
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int num: bloomDay){
            low = Math.min(low,num);
            high = Math.max(high,num);
        }

        int ans = high;
        while(low<=high){
            int mid = low+(high-low)/2;

            if(isPossible(bloomDay,mid,m,k)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
            
        }
        return ans;
    }

    static boolean isPossible(int[] arr, int mid,int m,int k){
        int noOfBqts = 0;
        int ct  = 0;

        for(int i = 0;i<arr.length;i++){
            if(arr[i]<=mid){
                ct++;
            }
            else{
                noOfBqts+=(ct/k);
                ct = 0;
            }
        }
        noOfBqts+=(ct/k);
        if(noOfBqts>=m) return true;
        return false;
        
    }
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println("Output: "+minDays(bloomDay, m, k));
    }
}