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

public class BalancedTree {

    static int check(TreeNode root) {
        if (root == null)
            return 0;

        int lh = check(root.left);
        int rh = check(root.right);

        if (lh == -1 || rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;

        return Math.max(lh, rh) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if (check(root) == -1)
            return false;

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(isBalanced(root));
    }
}