package leetcode.editor.cn.leetcode.editor.cn;

import c.leetcode.editor.cn.PathSum;
import leetcode.editor.cn.Leetcode6154;
import leetcode.editor.cn.T437_PathSumIii.TreeNode;

public class Leetcode450 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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

}
