//给你一个下标从 0 开始长度为 n 的整数数组 nums ，和一个下标从 0 开始长度为 m 的整数数组 pattern ，pattern 数组只包含整数 
//-1 ，0 和 1 。 
//
// 大小为 m + 1 的子数组 nums[i..j] 如果对于每个元素 pattern[k] 都满足以下条件，那么我们说这个子数组匹配模式数组 
//pattern ： 
//
// 
// 如果 pattern[k] == 1 ，那么 nums[i + k + 1] > nums[i + k] 
// 如果 pattern[k] == 0 ，那么 nums[i + k + 1] == nums[i + k] 
// 如果 pattern[k] == -1 ，那么 nums[i + k + 1] < nums[i + k] 
// 
//
// 请你返回匹配 pattern 的 nums 子数组的 数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4,5,6], pattern = [1,1]
//输出：4
//解释：模式 [1,1] 说明我们要找的子数组是长度为 3 且严格上升的。在数组 nums 中，子数组 [1,2,3] ，[2,3,4] ，[3,4,5] 和
// [4,5,6] 都匹配这个模式。
//所以 nums 中总共有 4 个子数组匹配这个模式。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,4,4,1,3,5,5,3], pattern = [1,0,-1]
//输出：2
//解释：这里，模式数组 [1,0,-1] 说明我们需要找的子数组中，第一个元素小于第二个元素，第二个元素等于第三个元素，第三个元素大于第四个元素。在 
//nums 中，子数组 [1,4,4,1] 和 [3,5,5,3] 都匹配这个模式。
//所以 nums 中总共有 2 个子数组匹配这个模式。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n == nums.length <= 10⁶ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= m == pattern.length < n 
// -1 <= pattern[i] <= 1 
// 
//
// Related Topics 数组 字符串匹配 哈希函数 滚动哈希 👍 5 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-02-13 16:52:00
 */
public class NumberOfSubarraysThatMatchAPatternIi{
    public static void main(String[] args) {
        Solution solution = new NumberOfSubarraysThatMatchAPatternIi().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        return kmpSearch(nums, pattern);
    }
    public int[] kmp(int[] pattern) {
        int n = pattern.length;
        int[] result = new int[pattern.length];
        int c = 0;
        for (int i = 1; i < n; i++) {
            int current = pattern[i];
            while (c > 0 && pattern[c] != current) {
                c = result[c - 1];
            }
            if (pattern[c] == current) {
                c++;
            }
            result[i] = c;
        }
        return result;
    }
    public int kmpSearch(int[] text, int[] pattern) {
        int[] match = kmp(pattern);
        int lenP = pattern.length;
        int result = 0;
        int c = 0;
        for (int i = 1; i < text.length; i++) {
            int current = text[i] < text[i - 1] ? -1 : text[i] == text[i - 1] ? 0 : 1;
            while (c > 0 && pattern[c] != current) {
                c = match[c - 1];
            }
            if (pattern[c] == current) {
                c++;
            }
            if (c == lenP) {
                result++;
                c = match[c - 1];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}