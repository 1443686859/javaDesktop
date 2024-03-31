//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
// root 。 
//
// 除了
// root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的
//房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1860 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import com.leetcode.editor.cn.ConvertSortedArrayToBinarySearchTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-09-18 22:55:12
 */
public class HouseRobberIii{
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
   }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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

    Map<TreeNode, Integer> robMap;
    Map<TreeNode, Integer> unRobMap;
    public int rob(TreeNode root) {
        robMap = new HashMap<>();
        unRobMap = new HashMap<>();
        dfs(root);
        return Math.max(robMap.get(root), unRobMap.get(root));
    }
    public void dfs(TreeNode root) {
        if (robMap.containsKey(root) && unRobMap.containsKey(root)) {
            return;
        }
        if (root.left == null && root.right == null) {
            robMap.put(root, root.val);
            unRobMap.put(root, 0);
            return ;
        }
        int unRob = 0;
        int rob = 0;
        if (root.left != null) {
            dfs(root.left);
            unRob += Math.max(robMap.get(root.left), unRobMap.get(root.left));
            rob += unRobMap.get(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
            unRob += Math.max(robMap.get(root.right), unRobMap.get(root.right)) ;
            rob += unRobMap.get(root.right);
        }
        robMap.put(root, rob + root.val);
        unRobMap.put(root, unRob);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}