//lc 1423

class MaxPoints {
    static int maxScore(int[] cardPoints, int k) {
        int lSum = 0;
        int rSum = 0;
        int maxSum = 0;
        int rIndex = cardPoints.length-1;

        for(int i = 0;i<k;i++){
            lSum+=cardPoints[i];
        }
        maxSum = lSum;

        for(int i = k-1;i>=0;i--){
            lSum-=cardPoints[i];
            rSum+=cardPoints[rIndex--];
            maxSum = Math.max(maxSum,rSum+lSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println("Output: "+maxScore(cardPoints,k));
    }
}