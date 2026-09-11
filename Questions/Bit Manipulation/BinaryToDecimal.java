
public class BinaryToDecimal {
    static int decimal(String n){
        int pow = 1;
        int num = 0;
   
        for(int i = n.length()-1;i>=0;i--){
             if(n.charAt(i)=='1') num = num+pow;
            pow*=2;
        }
        return num;
    }
    
    public static void main(String[] args) {
        String binary = "100";
        System.out.println(decimal(binary));
    }
}
