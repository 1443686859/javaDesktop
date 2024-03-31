package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode6335 {
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

    public TreeNode replaceValueInTree(TreeNode root) {
        TreeNode temp = root;
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        treeNodeDeque.add(temp);
        while (!treeNodeDeque.isEmpty()) {
            int size = treeNodeDeque.size();
            List<Integer> start = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                temp = treeNodeDeque.poll();
                if (temp != null) {
                    treeNodeDeque.addLast(temp.left);
                    treeNodeDeque.addLast(temp.right);
                }
//                start.add()
            }
        }
        return null;
      }
}
