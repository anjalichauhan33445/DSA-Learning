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

public class PathSum {

    static boolean dfs(TreeNode root, int t) {
        if (root == null)
            return false;

        t = t - root.val;

        if (root.left == null && root.right == null) {
            if (t == 0)
                return true;
        }

        boolean lc = dfs(root.left, t);
        boolean rc = dfs(root.right, t);

        return lc || rc;
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        int targetSum = 22;

        System.out.println(hasPathSum(root, targetSum));
    }
}