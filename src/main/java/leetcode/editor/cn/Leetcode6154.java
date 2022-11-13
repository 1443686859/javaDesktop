package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Leetcode6154 {
      class TreeNode {
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
    Map<Integer, Integer> depthMap ;
    Map<Integer, TreeNode> parentMap;
    public int amountOfTime(TreeNode root, int start) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        depthMap = new HashMap<>();
        parentMap = new HashMap<>();
        dfs(root, 1);
        int tempLength = depthMap.get(start);
        TreeNode currentParent = parentMap.get(start);
        int totalLength = depthMap.get(root.val);
        return 0;
    }
    public int dfs(TreeNode root, int currentLength) {
        if (depthMap.containsKey(root.val)) {
            return depthMap.get(root.val);
        }
        int leftLength = currentLength;
        int rightLength = currentLength;
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            leftLength = dfs(root.left, 1);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            rightLength = dfs(root.right, 1);
        }
        depthMap.put(root.val, Math.max(leftLength, rightLength) + 1);
        return depthMap.get(root.val);
    }
}
