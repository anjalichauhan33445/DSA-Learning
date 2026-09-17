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

public class GoodNodesBT {
    static int ct = 0;

    public static int goodNodes(TreeNode root) {
        check(root, root.val);
        return ct;
    }

    static void check(TreeNode root, int maxm) {
        if (root == null)
            return;

        if (root.val >= maxm) {
            ct++;
        }

        maxm = Math.max(maxm, root.val);

        check(root.left, maxm);
        check(root.right, maxm);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(goodNodes(root));
    }
}