//给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 
//
// 示例 1： 
//
// 
//输入: root = [5,3,6,2,4,null,7], k = 9
//输出: true
// 
//
// 示例 2： 
//
// 
//输入: root = [5,3,6,2,4,null,7], k = 28
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root 为二叉搜索树 
// -10⁵ <= k <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 357 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 *   @author YourName
 *   @date 2022-03-21 15:21:07
 */
public class TwoSumIvInputIsABst{
    public static void main(String[] args) {
        Solution solution = new TwoSumIvInputIsABst().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)

//  Definition for a binary tree node.
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
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        } else {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            List<TreeNode> currentList = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                if (set.contains(k - current.val)) {
                    return true;
                }
                set.add(current.val);
                if (current.left != null) {
                    currentList.add(current.left);
                }
                if (current.right != null) {
                    currentList.add(current.right);
                }
            }
            queue.addAll(currentList);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}