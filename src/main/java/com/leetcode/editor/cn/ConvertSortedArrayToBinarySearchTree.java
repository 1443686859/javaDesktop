//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索

package com.leetcode.editor.cn;


import java.util.ArrayList;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        TreeNode root = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(root);
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return changeToTree(nums, 0, nums.length - 1);
    }
    public TreeNode changeToTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = changeToTree(nums, left, mid - 1);
        root.right = changeToTree(nums, mid + 1, right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}