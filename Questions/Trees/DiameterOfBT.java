
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DiameterOfBT {

    static int maxm = 0;

    static int find(TreeNode root) {
        if (root == null)
            return 0;

        int lh = find(root.left);
        int rh = find(root.right);

        maxm = Math.max(maxm, lh + rh);

        return Math.max(lh, rh) + 1;
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        find(root);
        return maxm;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
    }
}