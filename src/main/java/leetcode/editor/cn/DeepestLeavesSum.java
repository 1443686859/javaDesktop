//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 示例 2： 
//
// 
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 之间。 
// 1 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 131 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2022-08-17 21:29:46
 */
public class DeepestLeavesSum{
    public static void main(String[] args) {
        Solution solution = new DeepestLeavesSum().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
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
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int level = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int result = 0;
        while (!deque.isEmpty()) {
            int currentResult = 0;
            int currentSize = deque.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode current = deque.pop();
                currentResult += current.val;
                if (current.left != null) {
                    deque.offer(current.left);
                }
                if (current.right != null) {
                    deque.offer(current.right);
                }
            }
            level++;
            result = currentResult;
        }
            return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}