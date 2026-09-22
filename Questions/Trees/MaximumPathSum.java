public class MaximumPathSum {

    static class TreeNode {
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

    static int maxm = Integer.MIN_VALUE;

    static int allPath(TreeNode root) {
        if (root == null) return 0;

        int lSum = Math.max(0, allPath(root.left));
        int rSum = Math.max(0, allPath(root.right));

        maxm = Math.max(maxm, lSum + rSum + root.val);

        return root.val + Math.max(lSum, rSum);
    }

    static int maxPathSum(TreeNode root) {
        allPath(root);
        return maxm;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(maxPathSum(root));
    }

}
