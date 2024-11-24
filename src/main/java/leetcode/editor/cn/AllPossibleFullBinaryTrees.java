//给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。 
//
// 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。 
//
// 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 7
//输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0
//,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：[[0,0,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 树 递归 记忆化搜索 动态规划 二叉树 👍 388 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-04-02 21:20:54
 */
public class AllPossibleFullBinaryTrees{
    public static void main(String[] args) {
        Solution solution = new AllPossibleFullBinaryTrees().new Solution();
        System.out.println(solution.allPossibleFBT(3));
   }
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
class Solution {
    Map<Integer, List<TreeNode>> memo;
    public List<TreeNode> allPossibleFBT(int n) {
        memo = new HashMap<>();
        List<TreeNode> result = create(n);
        return result;
    }
    public List<TreeNode> create(int count) {
        if (memo.containsKey(count)) {
            return memo.get(count);
        }
        if (count == 1) {
            TreeNode root = new TreeNode(0);
            List<TreeNode> result = new ArrayList<>();
            result.add(root);
            return result;
        }
        int rest = count - 1;
        List<TreeNode> result = new ArrayList<>();
        for (int left = 1; left <= rest; left += 2) {
            List<TreeNode> leftT = create(left);
            List<TreeNode> right = create(rest - left);
            for (TreeNode leftTemp : leftT) {
                for (TreeNode rightT : right) {
                    TreeNode root = new TreeNode(0);
                    root.left =leftTemp;
                    root.right = rightT;
                    result.add(root);
                }
            }
        }
        memo.put(count, result);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}