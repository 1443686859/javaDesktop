package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcodee6242 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        int n = queries.size();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            int target = queries.get(i);
            TreeNode temp = root;
            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;
            while (temp != null) {
                if (temp.val > target) {
                    temp = temp.left;
                } else if (temp.val == target) {
                    min = temp.val;
                    break;
                } else if (temp.val < target) {
                    min = Math.max(min, temp.val);
                    temp = temp.right;
                }
            }
            temp = root;
            while (temp != null) {
                if (temp.val < target) {
                    temp = temp.right;
                } else if (temp.val == target) {
                    max = temp.val;
                    break;
                } else if (temp.val > target) {
                    max = Math.min(max, temp.val);
                    temp = temp.left;
                }
            }
            result.add(Arrays.asList(min == Integer.MIN_VALUE ? - 1: min, max == Integer.MAX_VALUE ? -1 : max));
        }
        return result;
    }
}
