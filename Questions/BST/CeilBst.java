import org.w3c.dom.Node;



public class CeilBst {
    static  class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
    } 
     static  int findCeil(Node root, int x) {
        int ceil = -1;
        while(root!=null){
            if(root.data==x){
                ceil = root.data;
                return ceil;
            }
            else if(root.data>x){
                ceil = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ceil;
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right.left = new Node(10);
        root.right.right = new Node(14);

        int x =5;

        System.out.println("Ceil: "+ findCeil(root, x));
    }
}





