//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 163 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en




import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2022-05-16 18:56:57
 */
public class SuccessorLcci{
    public static void main(String[] args) {
        Solution solution = new SuccessorLcci().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        TreeNode pre = null;
        TreeNode result = null;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (pre == p) {
                return current;
            }
            pre = current;
            current = current.right;

        }
        return null;
    }
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
            if (p.right != null) {
                TreeNode current = p.right;
                while (current.left != null) {
                    current = current.left;
                }
                return current;
            }
            TreeNode result = null;
            TreeNode current = root;
            while (current != null) {
                if (current.val > p.val) {
                    result = current;
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}