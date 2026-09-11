
public class DecimalToBinary {
    static String Binary(int n){
        String num= "";
        while(n>0){
            if(n%2==1) num = num+"1";
            else num = num+"0";
            n = n/2;
        }
        return new StringBuilder(num).reverse().toString();
    }
    public static void main(String[] args) {
        int num = 4;
        System.out.println(Binary(num));
    }

}
