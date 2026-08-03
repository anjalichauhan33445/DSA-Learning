class KokoEatingBananas{
    static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int low = 1;
        
        for(int i = 0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        int high = max;
        int ans = 1;

        while(low<=high){
            int mid = low+(high-low)/2;
            long hrs = totalHrs(piles,mid);
            if(hrs>h){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }

    static long totalHrs(int[] piles,int mid){
        long h = 0;
        for(int i = 0;i<piles.length;i++){
            h+=Math.ceil((double)piles[i]/mid);
        }
        return h;
    }
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println("Output: "+minEatingSpeed(piles,h));
    }
}