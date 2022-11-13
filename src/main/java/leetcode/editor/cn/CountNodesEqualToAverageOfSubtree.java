//给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。 
//
// 注意： 
//
// 
// n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。 
// root 的 子树 由 root 和它的所有后代组成。 
// 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,8,5,0,1,null,6]
//输出：5
//解释：
//对值为 4 的节点：子树的平均值 (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4 。
//对值为 5 的节点：子树的平均值 (5 + 6) / 2 = 11 / 2 = 5 。
//对值为 0 的节点：子树的平均值 0 / 1 = 0 。
//对值为 1 的节点：子树的平均值 1 / 1 = 1 。
//对值为 6 的节点：子树的平均值 6 / 1 = 6 。
// 
//
// 示例 2： 
//
// 输入：root = [1]
//输出：1
//解释：对值为 1 的节点：子树的平均值 1 / 1 = 1。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// 0 <= Node.val <= 1000 
// 
// 👍 10 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 @author  YourName
 @date 2022-05-10 19:59:32
 */
public class CountNodesEqualToAverageOfSubtree{
    public static void main(String[] args) {
        Solution solution = new CountNodesEqualToAverageOfSubtree().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
//*
// Definition for a binary tree node.
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
        int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        getCount(root);
        return ans;
    }
    public int[] getCount(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];
        int[] left = getCount(root.left);
        int[] right = getCount(root.right);
        result[0] = left[0] + right[0] + root.val;
        result[1] = left[1] + right[1] + 1;
        if (result[0] / result[1] == root.val) {
            ans++;
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}