//给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：nums = [3,10,5,25,2,8]
//输出：28
//解释：最大运算结果是 5 XOR 25 = 28. 
//
// 示例 2： 
//
// 
//输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//输出：127
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// 0 <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 位运算 字典树 数组 哈希表 👍 614 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashSet;
import java.util.Set;

/**
 * @author  YourName
 * @date 2023-11-04 13:32:27
 */
public class MaximumXorOfTwoNumbersInAnArray{
    public static void main(String[] args) {
        Solution solution = new MaximumXorOfTwoNumbersInAnArray().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaximumXOR1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        int m = 32 - Integer.numberOfLeadingZeros(max);
        int ans = 0;
        int mask = 0;
        for (int i = m + 1; i >= 0; i--) {
            set.clear();
            int newAns = ans | (1 << i);
            mask |= 1 << i;
            for (int x : nums) {
                int temp = x & mask;
                if (set.contains(temp ^ newAns)) {
                    ans = newAns;
                    break;
                }
                set.add(temp);
            }
        }
        return ans;
    }
    class Trie {
        Trie left = null;
        Trie right = null;
    }
    Trie root = new Trie();
    static final int HIGH_BIT = 30;
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            add(i);
            ans = Math.max(ans, check(i));
        }
        return ans;
    }
    public void add(int num) {
        Trie next = root;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int current = (num >> i) & 1;
            if (current == 0) {
                if (next.left == null) {
                    next.left = new Trie();
                }
                next = next.left;
            } else {
                if (next.right == null) {
                    next.right = new Trie();
                }
                next = next.right;
            }
        }
    }
    public int check(int num) {
        Trie next = root;
        int x = 0;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int current = (num >> i) & 1;
            if (current == 0) {
                if (next.right != null) {
                    x = x * 2 + 1;
                    next = next.right;
                } else {
                    x *= 2;
                    next = next.left;
                }
            } else {
                if (next.left != null) {
                    x = x * 2 + 1;
                    next = next.left;
                } else {
                    x = x * 2;
                    next = next.right;
                }
            }
        }
        return x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}