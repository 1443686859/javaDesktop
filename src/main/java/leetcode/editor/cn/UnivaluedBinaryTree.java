//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。 
//
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,1,1,1,1,null,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：[2,2,2,5,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定树的节点数范围是 [1, 100]。 
// 每个节点的值都是整数，范围为 [0, 99] 。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 150 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2022-05-24 21:24:31
 */
public class UnivaluedBinaryTree{
    public static void main(String[] args) {
        Solution solution = new UnivaluedBinaryTree().new Solution();
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
    public boolean isUnivalTree(Leetcode5944.TreeNode root) {
        int currentVal = root.val;
        Deque<Leetcode5944.TreeNode> stack = new ArrayDeque<>();
        Leetcode5944.TreeNode start = root;
        stack.push(root);
        while (start != null || !stack.isEmpty()) {
            while (start != null) {
                stack.push(start);
                start = start.left;
            }
            start = stack.pop();
            if (start.val != currentVal) {
                return false;
            }
            start = start.right;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}