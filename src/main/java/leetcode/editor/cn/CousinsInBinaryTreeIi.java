//给你一棵二叉树的根 root ，请你将每个节点的值替换成该节点的所有 堂兄弟节点值的和 。 
//
// 如果两个节点在树中有相同的深度且它们的父节点不同，那么它们互为 堂兄弟 。 
//
// 请你返回修改值之后，树的根 root 。 
//
// 注意，一个节点的深度指的是从树根节点到这个节点经过的边数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,4,9,1,10,null,7]
//输出：[0,0,0,7,7,null,11]
//解释：上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
//- 值为 5 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 4 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 9 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 1 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
//- 值为 10 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
//- 值为 7 的节点有两个堂兄弟，值分别为 1 和 10 ，所以值修改为 11 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [3,1,2]
//输出：[0,0,0]
//解释：上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
//- 值为 3 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 1 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 2 的节点没有堂兄弟，所以值修改为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目的范围是 [1, 10⁵] 。 
// 1 <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 51 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  YourName
 * @date 2024-02-07 21:45:24
 */
public class CousinsInBinaryTreeIi{
    public static void main(String[] args) {
        Solution solution = new CousinsInBinaryTreeIi().new Solution();
        TreeNode root = new TreeNode(5,new TreeNode(4), new TreeNode(9));
        System.out.println(solution.replaceValueInTree(root));
   }
    static class TreeNode {
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
    List<Integer> count;
    public TreeNode replaceValueInTree(TreeNode root) {
        count = new ArrayList<>();
        dfs(root, 0);
        root.val = 0;
        dfs1(root, 0);
        return root;
    }
    public void dfs(TreeNode root, int index) {
        if (root == null) {
            return ;
        }
        if (index >= count.size()) {
            count.add(0);
        }
        count.set(index, count.get(index) + root.val);
        dfs(root.left, index + 1);
        dfs(root.right, index + 1);
    }
    public void dfs1(TreeNode root, int index) {
        int current = root.right != null ? root.right.val : 0;
        current += root.left != null ? root.left.val : 0;
        if (root.right != null) {
            root.right.val = count.get(index + 1) - current;
            dfs1(root.right, index + 1);
        }
        if (root.left != null) {
            root.left.val = count.get(index + 1) - current;
            dfs1(root.left, index + 1);
        }


    }

}
//leetcode submit region end(Prohibit modification and deletion)

}