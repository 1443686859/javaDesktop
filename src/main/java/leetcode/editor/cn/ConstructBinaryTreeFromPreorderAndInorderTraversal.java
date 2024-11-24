//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2207 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
  @author  YourName
  @date 2024-02-20 00:07:42
 **/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return create(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode create(int[] preOrder, int start, int end, int[] inOrder, int inStart, int inEnd) {
        if (start > end || inStart > inEnd)  {
            return null;
        }
        int temp = inStart;
        while (inOrder[temp] != preOrder[start]) {
            temp++;
        }
        TreeNode root = new TreeNode(preOrder[start]);
        root.left = create(preOrder, start + 1, start + (temp - inStart), inOrder, inStart, temp);
        root.right = create(preOrder, start + (temp - inStart) + 1, end, inOrder, temp + 1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}