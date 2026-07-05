class LongestOnes {
    static int longestOnes(int[] nums, int k) {
        int ct = 0;
        int i = 0;
        int max_len = 0;
        for(int j = 0; j<nums.length; j++){
            if(nums[j]==0) ct++;
            while(ct>k){
                if(nums[i]==0) ct--;
                i++;
            }
            max_len = Math.max(max_len, j-i+1);
        }
        return max_len;
        
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println("The maximum consecutive Ones after flipping are: "+longestOnes(nums, k));
    }

}