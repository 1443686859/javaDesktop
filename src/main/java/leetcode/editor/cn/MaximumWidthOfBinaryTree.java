//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。 
//
// 树的 最大宽度 是所有层中最大的 宽度 。 
//
// 
// 
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
//null 节点，这些 null 节点也计入长度。 
// 
// 
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 3000] 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 437 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-08-27 10:21:52
 */
public class MaximumWidthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumWidthOfBinaryTree().new Solution();
        TreeNode tempLeft = new TreeNode(3, new TreeNode(5), null);
        TreeNode tempRight = new TreeNode(2);
        TreeNode root = new TreeNode(1, tempLeft, tempRight);
        System.out.println(solution.widthOfBinaryTree(root));
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

  public static class TreeNode {
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
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        int ans = 1;
        deque.add(root);
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> currentStartList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = deque.poll();
                if (current.left != null) {
                    deque.add(current.left);
                    currentStartList.add(2 * temp.get(i));
                }
                if (current.right != null) {
                    deque.add(current.right);
                    currentStartList.add(2 * temp.get(i) + 1);
                }
            }
            int currentAns = temp.get(temp.size() - 1) - temp.get(0) + 1;
            ans = Math.max(ans, currentAns);
            temp.clear();
            temp.addAll(currentStartList);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}