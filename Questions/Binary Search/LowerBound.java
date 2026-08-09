class LowerBound {
    static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>=target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] arr= {2, 3, 7, 10, 11, 11, 25};
        int target = 9;
        System.out.println("Output: "+lowerBound(arr, target));
    }
}
