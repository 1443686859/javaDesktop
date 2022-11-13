//给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [5,2,-3]
//输出: [2,-3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: root = [5,2,-5]
//输出: [2]
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 173 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  YourName
 * @date 2022-06-19 15:03:48
 */
public class MostFrequentSubtreeSum{
    public static void main(String[] args) {
        Solution solution = new MostFrequentSubtreeSum().new Solution();
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
      Map<Integer, Integer> freeMap;
      int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        freeMap = new HashMap<>();
        sum(root);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freeMap.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        int n = result.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        int currentResult = root.val + left + right;
        freeMap.put(currentResult, freeMap.getOrDefault(currentResult, 0) + 1);
        max = Math.max(max, freeMap.get(currentResult));
        return currentResult;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}