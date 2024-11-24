//给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。 
//
// 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ： 
//
// 
// mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。 
// maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。 
// 
//
// 返回数组 answer 。 
//
// 
//
// 示例 1 ： 
//
// 
//
// 
//输入：root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,1
//6]
//输出：[[2,2],[4,6],[15,-1]]
//解释：按下面的描述找出并返回查询的答案：
//- 树中小于等于 2 的最大值是 2 ，且大于等于 2 的最小值也是 2 。所以第一个查询的答案是 [2,2] 。
//- 树中小于等于 5 的最大值是 4 ，且大于等于 5 的最小值是 6 。所以第二个查询的答案是 [4,6] 。
//- 树中小于等于 16 的最大值是 15 ，且大于等于 16 的最小值不存在。所以第三个查询的答案是 [15,-1] 。
// 
//
// 示例 2 ： 
//
// 
//
// 
//输入：root = [4,null,9], queries = [3]
//输出：[[-1,4]]
//解释：树中不存在小于等于 3 的最大值，且大于等于 3 的最小值是 4 。所以查询的答案是 [-1,4] 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [2, 10⁵] 内 
// 1 <= Node.val <= 10⁶ 
// n == queries.length 
// 1 <= n <= 10⁵ 
// 1 <= queries[i] <= 10⁶ 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 数组 二分查找 二叉树 👍 55 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 *
 * @date 2024-02-24 15:17:48
 */
public class ClosestNodesQueriesInABinarySearchTree{

    public static void main(String[] args) {
        Solution solution = new ClosestNodesQueriesInABinarySearchTree().new Solution();
        System.out.println(solution.closestNodes(new TreeNode(
                6, new TreeNode(2, new TreeNode(1), new TreeNode(4)), new TreeNode(13, new TreeNode(9), new TreeNode(15, new TreeNode(14), null))), Arrays.asList(2,5,16)));
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
    List<Integer> current;
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        while (current != null || !deque.isEmpty()) {
            while (current != null) {
                deque.addLast(current);
                current = current.left;
            }
            current = deque.pollLast();
            list.add(current.val);
            current = current.right;
        }
        int[] arr = new int[list.size()];
        int index = 0;
        for (int i : list) {
            arr[index ++] = i;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i : queries) {
            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] >= i) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            index = right + 1;
            int max = index == list.size() ? -1 : arr[index];
            if (index == list.size() || arr[index] != i) {
                index--;
            }
            int min = index >= 0 ? arr[index] :  -1;
            result.add(Arrays.asList(min, max));
        }
        return result;
    }
    public List<List<Integer>> closestNodes1(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i : queries) {
            current = Arrays.asList(-1, Integer.MAX_VALUE);
            int min = -1;
            int max = Integer.MAX_VALUE;
            TreeNode temp = root;
            while (temp != null) {
                if (temp.val == i) {
                    min = i;
                    max = i;
                    break;
                } else if (temp.val > i) {
                    temp = temp.left;
                    max = Math.min(max, temp.val);
                } else {
                    temp = temp.right;
                    min = Math.max(min, temp.val);
                }
            }
            result.add(Arrays.asList(min, max == Integer.MAX_VALUE ? - 1 : max));
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}