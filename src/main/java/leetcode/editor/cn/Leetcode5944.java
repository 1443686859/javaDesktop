package leetcode.editor.cn;

public class Leetcode5944 {
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
    public String getDirections(TreeNode root, int startValue, int destValue) {
          String startPath = dfs(root, startValue, "");
          String destPath = dfs(root, destValue, "");
          if (startPath.length() != 0 && destPath.length() != 0) {
              if (startPath.charAt(0) == destPath.charAt(0)) {
                  int i = 1;
                  while (i < startPath.length() && i < destPath.length() &&startPath.charAt(i) == destPath.charAt(i)) {
                      i++;
                  }
                  startPath = startPath.substring(i - 1);
                  destPath = destPath.substring(i - 1);
              }
          }
          startPath = startPath.replace('L', 'U');
          startPath = startPath.replace('R', 'U');
          return startPath + destPath;

    }
    public String dfs(TreeNode root, int target, String currentPath) {
          if (root.val == target) {
              return currentPath;
          }
          String left = null;
          String right = null;
          if (root.left != null) {
              left = dfs(root.left, target, currentPath + "L");
          }
          if (root.right != null) {
              right = dfs(root.right, target, currentPath + "R");
          }
          if (left != null && right != null) {
              if (left.contains("X")) {
                  return right;
              }
              if (right.contains("X")) {
                  return left;
              }
              return left.length() >= right.length() ? right : left;
          }
          if (left == null && right == null) {
              // 舍弃节点
              return "XXXXXXXX";
          }
          return left != null ? left :right;
    }
}
