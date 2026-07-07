//leetcode 1248

class NumberOfSubarrays {
    static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
        
    }

    static int atMost(int[] nums, int k){
        int i = 0;
        int odd = 0;
        int ct = 0;
        for(int j = 0; j<nums.length; j++){
            if(nums[j]%2!=0) odd++;

            while(odd>k){
                if(nums[i]%2!=0) odd--;
                i++;
                
            }
            ct+=j-i+1;

        }
        return ct;
    }

    
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println("Output :"+numberOfSubarrays(nums, k));
    }
}