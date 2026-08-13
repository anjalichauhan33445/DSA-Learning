class TrappingRain {
    static int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        for(int i =1; i<height.length;i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        right[n-1] = height[n-1];
        for(int i = n-2; i>=0; i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        for(int i =0; i<height.length;i++){
            ans+=(Math.min(left[i],right[i])-height[i]);
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int[]height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Output: "+trap(height));
    }
}