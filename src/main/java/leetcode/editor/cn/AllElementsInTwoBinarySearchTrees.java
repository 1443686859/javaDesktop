//给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树的节点数在 [0, 5000] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 👍 101 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author  YourName
 * @date 2022-05-01 10:27:51
 */
public class AllElementsInTwoBinarySearchTrees{
    public static void main(String[] args) {
        Solution solution = new AllElementsInTwoBinarySearchTrees().new Solution();
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        TreeNode root = new TreeNode(2, left, right);
        System.out.println(solution.getList(root));
   }
    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> one = getList(root1);
            List<Integer> two = getList(root2);
            one.addAll(two);
            Collections.sort(one);
            return one;
        }
        public List<Integer> getList(TreeNode root1) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            List<Integer> result = new ArrayList<>();
            TreeNode temp = root1;
            while (temp != null || !stack.isEmpty()) {
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
                if (!stack.isEmpty()) {
                    temp = stack.pop();
                    result.add(temp.val);
                    temp = temp.right;
                }
            }
            return result;
        }
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


//leetcode submit region end(Prohibit modification and deletion)

}