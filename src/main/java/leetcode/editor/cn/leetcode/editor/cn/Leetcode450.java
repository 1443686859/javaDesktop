package leetcode.editor.cn.leetcode.editor.cn;

import c.leetcode.editor.cn.PathSum;
import leetcode.editor.cn.T437_PathSumIii.TreeNode;

public class Leetcode450 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        TreeNode right = new TreeNode(6, null, new TreeNode(7));
        root.left = left;
        root.right = right;
        Leetcode450 leetcode450 = new Leetcode450();
        System.out.println(leetcode450.deleteNode(root, 7));
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode pre = null;
        TreeNode current = root;
        while (current != null && current.val != key) {
            pre = current;
            if (current.val > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null) {
            return root;
        }

        TreeNode newPre = current;
        TreeNode newCurrent = null;
        boolean newDirection = false;
        if (current.right != null) {
            newCurrent = current.right;
            newDirection = false;
            while (newCurrent.left != null) {
                newPre = newCurrent;
                newCurrent = newCurrent.left;
            }
        } else if (current.left != null) {
            newCurrent = current.left;
            newDirection = true;
            while (newCurrent.right != null) {
                newDirection = false;
                newPre = newCurrent;
                newCurrent = newCurrent.right;
            }
        }

        int resultVal = newCurrent.val;
        if (newDirection) {
            newPre.left = newCurrent.left;
        } else {
            newPre.right = newCurrent.right;
        }
        current.val = resultVal;
        return root;
    }

}
