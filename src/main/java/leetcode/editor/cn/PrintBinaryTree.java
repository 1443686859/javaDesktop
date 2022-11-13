//给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩
//阵需要遵循以下规则： 
//
// 
// 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。 
// 矩阵的列数 n 应该等于 2ʰᵉⁱᵍʰᵗ⁺¹ - 1 。 
// 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。 
// 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] ，右子节点放置在 
//res[r+1][c+2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] 。 
// 继续这一过程，直到树中的所有节点都妥善放置。 
// 任意空单元格都应该包含空字符串 "" 。 
// 
//
// 返回构造得到的矩阵 res 。 
//
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2]
//输出：
//[["","1",""],
// ["2","",""]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3,null,4]
//输出：
//[["","","","1","","",""],
// ["","2","","","","3",""],
// ["","","4","","","",""]]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在范围 [1, 2¹⁰] 内 
// -99 <= Node.val <= 99 
// 树的深度在范围 [1, 10] 内 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 183 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-08-22 21:34:33
 */
public class PrintBinaryTree{
    public static void main(String[] args) {
        Solution solution = new PrintBinaryTree().new Solution();
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
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<String>> printTree(TreeNode root) {
        int currentDept = getDepth(root);
        int m = currentDept + 1;
        int n = (1 << (currentDept + 1)) - 1;
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < m ;i++) {
            List<String> currentList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                currentList.add("");
            }
            result.add(currentList);
        }
        dfs(result, root, 0, (n - 1) / 2, currentDept);
        return result;
    }
    public int getDepth(TreeNode root) {
        int currentDepth = 0;
        if (root.left != null) {
            currentDepth = Math.max(currentDepth, getDepth(root.left) + 1);
        }
        if (root.right != null) {
            currentDepth = Math.max(currentDepth, getDepth(root.right) + 1);
        }
        return currentDepth;
    }
    public void dfs(List<List<String>> result, TreeNode currentNode, int r, int c, int currentDept) {
        result.get(r).set(c, currentNode.val + "");
        if (currentNode.left != null) {
            dfs(result, currentNode.left, r + 1, c - (1 << (currentDept - r - 1)), currentDept);
        }
        if (currentNode.right != null) {
            dfs(result, currentNode.right, r + 1, c + (1 << (currentDept - r - 1)), currentDept);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}