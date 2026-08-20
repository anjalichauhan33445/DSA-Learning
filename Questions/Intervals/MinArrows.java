import java.util.Arrays;

class MinArrows {
    static int findMinArrowShots(int[][] points) {
       Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
       int last = points[0][1];
       int ct = 1;
       for(int i = 1;i<points.length;i++){
        if(points[i][0]>last){
            ct++;
            last = points[i][1];
        }
       }
       return ct;
    }
    public static void main(String[] args) {
        int[][]points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println("Output: "+findMinArrowShots(points));
    }
}