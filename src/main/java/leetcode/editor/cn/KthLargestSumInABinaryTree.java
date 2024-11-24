//给你一棵二叉树的根节点 root 和一个正整数 k 。 
//
// 树中的 层和 是指 同一层 上节点值的总和。 
//
// 返回树中第 k 大的层和（不一定不同）。如果树少于 k 层，则返回 -1 。 
//
// 注意，如果两个节点与根节点的距离相同，则认为它们在同一层。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,8,9,2,1,3,7,4,6], k = 2
//输出：13
//解释：树中每一层的层和分别是：
//- Level 1: 5
//- Level 2: 8 + 9 = 17
//- Level 3: 2 + 1 + 3 + 7 = 13
//- Level 4: 4 + 6 = 10
//第 2 大的层和等于 13 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,null,3], k = 1
//输出：3
//解释：最大的层和是 3 。
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 
// 2 <= n <= 10⁵ 
// 1 <= Node.val <= 10⁶ 
// 1 <= k <= n 
// 
//
// Related Topics 树 广度优先搜索 二叉树 排序 👍 15 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-02-23 00:02:44
 */
public class KthLargestSumInABinaryTree{
    public static void main(String[] args) {
        Solution solution = new KthLargestSumInABinaryTree().new Solution();
        System.out.println(solution.kthLargestLevelSum(new TreeNode(411310, new TreeNode(211244), new TreeNode(111674)), 2));
   }
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
    
    List<Long> result;
    public long kthLargestLevelSum(TreeNode root, int k) {
        result = new ArrayList<>();
        dfs(root, 0);
        Collections.sort(result);
        return result.size() < k ? -1 : result.get(result.size() - k);
    }
    public void dfs(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (index >= result.size()) {
            result.add(root.val * 1L);
        } else {
            long current = result.get(index);
            current += root.val;
            result.set(index, current);
        }
        dfs(root.left, index + 1);
        dfs(root.right, index + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}