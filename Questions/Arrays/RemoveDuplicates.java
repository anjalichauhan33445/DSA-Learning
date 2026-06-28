class RemoveDuplicates{

    static int removeDuplicates(int[] arr) {
        int i = 0;
        for(int j = 0; j<arr.length; j++){
            if(arr[j]!=arr[i]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }
    
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.err.println("The number of Distinct Numbers are: "+removeDuplicates(nums));

    }
}