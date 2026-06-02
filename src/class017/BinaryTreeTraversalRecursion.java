package class017;

/**
 * 二叉树递归遍历
 *
 */

public class BinaryTreeTraversalRecursion {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            this.val = v;
        }
    }

    /**
     * 前序遍历
     */
    public static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        preOrder(head.left);
        preOrder(head.right);
    }

    /**
     * 中序遍历
     */
    public static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.println(head.val);
        inOrder(head.right);
    }

    /**
     * 后序遍历
     */
    public static void postOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.println(head.val);
    }
}
