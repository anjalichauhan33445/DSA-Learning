public class FloorBst {

    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    static int findMaxFork(Node root, int k) {
        int ans = -1;

        while(root != null) {
            if(root.data == k) {
                return root.data;
            }
            else if(root.data > k) {
                root = root.left;
            }
            else {
                ans = root.data;
                root = root.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right.left = new Node(10);
        root.right.right = new Node(14);

        int k = 7;

        System.out.println("Floor: " + findMaxFork(root, k));
    }
}
