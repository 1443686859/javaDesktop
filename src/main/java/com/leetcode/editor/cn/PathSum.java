//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索

package c.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
        public int res = 0;
        public int sign = 0;
/*    public boolean hasPathSum(TreeNode root, int sum) {
        // 回溯法
        back(root, sum);
        return sign == 1;
    }*/
    public void back(TreeNode root, int sum) {
        if (root == null) {
            return ;
        }
        res += root.val;
        // 设置结束出口 当遍历的节点为叶子节点的时候结束
        if (res == sum &&root.left == null && root.right == null) {
           // 存在路径
            sign = 1;
            return ;
        }
        back(root.left, sum);
        back(root.right, sum);
        res -= root.val;

    }
  /*  public boolean hasPathSum(TreeNode root, int sum) {
        // 采用dfs计算到叶子节点的总和
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }*/
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> val = new LinkedList<>();
        queue.offer(root);
        val.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode root1 = queue.poll();
            int temp = val.poll();
            if (temp == sum && root1.left == null && root1.right == null) {
                return true;
            }
            if (root1.left != null) {
                queue.offer(root1.left);
                val.offer(root1.left.val + temp);
            }
            if (root1.right != null) {
                queue.offer(root1.right);
                val.offer(root1.right.val + temp);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}