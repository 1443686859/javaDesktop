//给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵
//树的后序遍历，重构并返回二叉树。 
//
// 如果存在多个答案，您可以返回其中 任何 一个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1], postorder = [1]
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// preorder 中所有值都 不同 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// postorder 中所有值都 不同 
// 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 341 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-02-22 00:46:23
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
        System.out.println(solution.constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1}));
   }

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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return create(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode create(int[] pre, int pS, int pE, int[] post, int oS, int oE) {
        if (pS > pE || oS > oE) {
            return null;
        }
        TreeNode current = new TreeNode(pre[pS]);
        if (pS == pE) {
            return current;
        }
        int leftEnd = pS + 1;
        int temp = oS;
        while (pre[leftEnd] != post[temp] && temp <= oE) {
            temp++;
        }
        current.left = create(pre, leftEnd, leftEnd + (temp - oS), post, oS, temp);
        current.right = create(pre, leftEnd + (temp - oS) + 1, pE,post, temp + 1, oE - 1);
        return current;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}