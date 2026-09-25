import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    static List<Integer> rows(int row){
        int ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);

        for(int col = 1; col<row;col++){
            ans*=(row-col);
            ans/=col;
            ansRow.add(ans);
        }
        return ansRow;
    }
    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1;i<=numRows;i++){
            List<Integer> temp = rows(i);
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
    public static void main(String[] args) {
       int numRows = 5;
       System.out.println(generate(numRows));
    }
}
