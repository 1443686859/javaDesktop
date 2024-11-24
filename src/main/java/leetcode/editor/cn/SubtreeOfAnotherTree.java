/**

 
 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返
回 false 。 
 
 

 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 

 

 示例 1： 
 
 
输入：root = [3,4,5,1,2], subRoot = [4,1,2]
输出：true
 

 示例 2： 
 
 
输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
输出：false
 

 

 提示： 

 
 root 树上的节点数量范围是 [1, 2000] 
 subRoot 树上的节点数量范围是 [1, 1000] 
 -10⁴ <= root.val <= 10⁴ 
 -10⁴ <= subRoot.val <= 10⁴ 
 

 👍 1072 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-08-04 21:54:03
 */
public class SubtreeOfAnotherTree{
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode sub = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(solution.isSubtree(root, sub));
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

  boolean result;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        result = false;
        dfs(root, subRoot);
        return result;
    }
    public void dfs(TreeNode root, TreeNode sub) {
        if (check(root, sub)) {
            result = true;
            return ;
        }
        if (root == null && sub != null) {
            return ;
        }
        dfs(root.left, sub);
        dfs(root.right, sub);
    }
    public boolean check(TreeNode root, TreeNode sub) {
        if (root == null && sub != null) {
            return false;
        }
        if (root != null && sub == null) {
            return false;
        }
        if (root == null && sub == null) {
            return true;
        }
        boolean result = root.val == sub.val;
        if (!result) {
            return false;
        }
        boolean left = check(root.left, sub.left);
        boolean right = check(root.right, sub.right);
        return left & right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}