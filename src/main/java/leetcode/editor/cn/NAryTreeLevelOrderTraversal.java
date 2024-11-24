//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
// Related Topics 树 广度优先搜索 👍 258 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2022-04-08 19:36:30
 */
public class NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
        System.out.println(solution.maxOperations1(new int[]{3,2,1,2,3,4}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> total = new ArrayDeque<>();
        if (root != null) {
            total.add(root);
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!total.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            int size = total.size();
            for (int i = 0; i < size; i++) {
               Node child = total.poll();
               current.add(child.val);
               if (child.children != null) {
                   total.addAll(child.children);
               }
            }
            result.add(current);
        }
        return result;
    }
    public int maxOperations(int[] nums) {
        int pre = 0;
        int after = 1;
        int target = nums[pre] + nums[after];
        int count = 0;
        while (after < nums.length && nums[pre] + nums[after] == target) {
            after += 2;
            pre += 2;
            count++;
        }
        return count;
    }
    public String lastNonEmptyString(String s) {
        int[] count = new int[26];
        int[] index = new int[26];
        StringBuilder result = new StringBuilder();
        int max = 0;
        int i = 0;
        for (Character c : s.toCharArray()) {
            count[c - 'a']++;
            index[c - 'a'] = i++;
            max = Math.max(max, count[c - 'a']);
        }
        i = 0;
        for (Character c : s.toCharArray()) {
            if (index[c-'a'] == i++ && count[c - 'a'] == max) {
                result.append(c);
            }
        }
        return result.toString();
    }
    int[][] memo;
    public int maxOperations1(int[] nums) {
        int n = nums.length;
        memo = new int[n][n];
        for (int[] m : memo) {
            Arrays.fill(m, - 1);
        }
        return 1+  Math.max(get(nums, 1, nums.length - 2, nums[0] + nums[nums.length - 1]), Math.max(
                get(nums, 0, nums.length - 3, nums[nums.length - 1] + nums[nums.length - 2]), get(nums
                , 2, nums.length- 1, nums[0] + nums[1]))
        );
    }
    public int get(int[] nums, int left, int right, int target) {
        if (left >= right) {
            return 0;
        }
        if (memo[left][right] != -1) {
            return memo[left][right];
        }
        int max = 0;
        if (nums[left] + nums[left + 1] == target) {
            max = Math.max(max, 1 + get(nums, left + 2, right, target));
        }
        if (nums[right] + nums[right - 1] == target) {
            max = Math.max(max, 1 + get(nums, left, right - 2, target));
        }
        if (nums[right] + nums[left] == target) {
            max = Math.max(max,  1 + get(nums, left + 1, right - 1, target));
        }
        memo[left][right] = max;
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}