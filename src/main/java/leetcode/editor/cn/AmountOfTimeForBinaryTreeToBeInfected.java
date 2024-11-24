//给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发
//。 
//
// 每分钟，如果节点满足以下全部条件，就会被感染： 
//
// 
// 节点此前还没有感染。 
// 节点与一个已感染节点相邻。 
// 
//
// 返回感染整棵树需要的分钟数。 
//
// 
//
// 示例 1： 
// 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
//输出：4
//解释：节点按以下过程被感染：
//- 第 0 分钟：节点 3
//- 第 1 分钟：节点 1、10、6
//- 第 2 分钟：节点5
//- 第 3 分钟：节点 4
//- 第 4 分钟：节点 9 和 2
//感染整棵树需要 4 分钟，所以返回 4 。
// 
//
// 示例 2： 
// 输入：root = [1], start = 1
//输出：0
//解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁵] 内 
// 1 <= Node.val <= 10⁵ 
// 每个节点的值 互不相同 
// 树中必定存在值为 start 的节点 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 93 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import com.leetcode.editor.cn.ConvertSortedArrayToBinarySearchTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2024-04-24 21:11:45
 */
public class AmountOfTimeForBinaryTreeToBeInfected{
    public static void main(String[] args) {
        Solution solution = new AmountOfTimeForBinaryTreeToBeInfected().new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null), null), null);
        System.out.println(solution.amountOfTime(root, 2));
   }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
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
    Map<Integer, TreeNode> parentMap;
    Map<Integer, int[]> childMap;
    public int amountOfTime(TreeNode root, int start) {
        parentMap = new HashMap<>();
        childMap = new HashMap<>();
        dfs(root, new TreeNode(0));
        int max = 0;
        int count = 0;
        int[] child = childMap.get(start);
        while (parentMap.containsKey(start)) {
            child = childMap.get(start);
            TreeNode parent = parentMap.get(start);
            int tempMax = count == 0 ? Math.max(child[0], child[1]) : (child[0] + child[1] - count);
            max = Math.max(max, tempMax);
            start = parent.val;
            count ++;
        }
        return max;
    }
    public int dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return 0;
        }
        parentMap.put(root.val, parent);
        int left = dfs(root.left, root);
        int right = dfs(root.right, root);
        int[] result = new int[]{left, right};
        childMap.put(root.val, result);
        return 1 + Math.max(left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}