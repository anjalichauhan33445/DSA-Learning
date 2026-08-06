class AllocateMinimum {
    static int findPages(int[] arr, int k) {
        if(arr.length<k) return -1;
        int low = 0;
        long high = 0;
        for(int num: arr){
            low = Math.max(num,low);
            high+=num;
        }
        
        while(low<=high){
            long mid = low+(high-low)/2;
            int student_ct = helper(arr,mid);
            if(student_ct<=k){
                high = mid-1;
            }
            else{
                low = (int)(mid+1);
            }
        }
        return low;
        
        
    }
    static int helper(int[] arr,long max_pages){
        long page_ct = 0;
        int students = 1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]+page_ct<=max_pages){
                page_ct+=arr[i];
            }
            else{
                students++;
                page_ct = arr[i];
            }
        }
        return students;
    }
    public static void main(String[] args){
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println("Output: "+findPages(arr,k));
    }
}