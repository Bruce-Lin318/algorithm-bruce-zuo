package class018;

import class017.BinaryTreeTraversalRecursion;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树迭代方式三序遍历
 *
 */

public class BinaryTreeTraversalIteration {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            this.val = v;
        }
    }

    /**
     * 迭代方式前序遍历
     */
    public static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }
}
