

public class InsertBst {
    
static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    } 

    static  Node insert(Node root, int val) {
        // code here
        if(root==null) return new Node(val);
        Node curr = root;
        
        while(true){
            if(curr.data==val) return root;
            if(curr.data<val){
                if(curr.right!=null) curr = curr.right;
                else{
                    curr.right = new Node(val);
                    break;
                }
            }
            else{
                if(curr.left!=null) curr = curr.left;
                else{
                    curr.left = new Node(val);
                    break;
                }
            }
        }
        return root;
        
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right.left = new Node(10);
        root.right.right = new Node(14);

        int rData = insert(root, 7).data;
        System.out.println(rData);
    }

}
