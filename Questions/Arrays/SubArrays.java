
import java.util.ArrayList;

class SubArrays{
    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5};
       ArrayList<ArrayList> list = new ArrayList<>();

       for(int i = 0; i<arr.length; i++){
       
         for(int j = i; j<arr.length; j++){
            ArrayList<Integer> temp = new ArrayList<>();
           
            for(int k = i; k<=j; k++){
                temp.add(arr[k]);
            }
            list.add(temp);
         }
        
         
       } 
       System.out.println(list);
       System.out.println(list.size());
    }
    
}