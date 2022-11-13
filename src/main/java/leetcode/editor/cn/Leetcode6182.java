package leetcode.editor.cn;


import com.leetcode.editor.cn.ConvertSortedArrayToBinarySearchTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode6182 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        int level = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<TreeNode> currentList = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = deque.poll();
                currentList.add(currentNode);
                current.add(currentNode.val);
                if (currentNode.left != null)
                deque.add(currentNode.left);
                if (currentNode.right != null)
                deque.add(currentNode.right);
            }
            if ((level & 1) != 0) {
                for (int i = 0; i < current.size(); i++) {
                    currentList.get(i).val = current.get(current.size() - 1 - i);
                }
            }
            level++;
        }
        return root;
    }
}
