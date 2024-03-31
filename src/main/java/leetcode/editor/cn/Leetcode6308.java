package leetcode.editor.cn;

import java.util.*;

public class Leetcode6308 {
    public class TreeNode {
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
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        List<Long> count = new ArrayList<>();
        int max = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            long currentSum = 0l;
            for (int i = 0; i < size; i++) {
                TreeNode current = deque.poll();
                currentSum += current.val;
                if (current.left != null) {
                    deque.addLast(current.left);
                }
                if (current.right != null) {
                    deque.addLast(current.right);
                }
            }
            count.add(currentSum);
            max++;
        }
        Collections.sort(count, (a ,b) -> a > b ? -1 : (a == b) ? 0 : 1);
        if (k >= max) {
            return -1;
        }
        return count.get(k - 1);
    }
}
