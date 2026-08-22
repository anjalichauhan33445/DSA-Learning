import java.util.HashMap;

class FruitsIntoBasket {

    static int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;

        while(r<fruits.length){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            while(map.size()>2){
                map.put(fruits[l],map.getOrDefault(fruits[l],0)-1);
                if(map.getOrDefault(fruits[l],0)==0) map.remove(fruits[l]);
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
            r++;

        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] fruits = {1,2,1};
        System.out.println("Output: "+ totalFruit(fruits));
    }
    
}
