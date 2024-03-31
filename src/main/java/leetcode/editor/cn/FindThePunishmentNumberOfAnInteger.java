//给你一个正整数 n ，请你返回 n 的 惩罚数 。 
//
// n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和： 
//
// 
// 1 <= i <= n 
// i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：182
//解释：总共有 3 个整数 i 满足要求：
//- 1 ，因为 1 * 1 = 1
//- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//因此，10 的惩罚数为 1 + 81 + 100 = 182
// 
//
// 示例 2： 
//
// 
//输入：n = 37
//输出：1478
//解释：总共有 4 个整数 i 满足要求：
//- 1 ，因为 1 * 1 = 1
//- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//- 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
//因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
//
// Related Topics 数学 回溯 👍 99 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-10-25 20:38:45
 */
public class FindThePunishmentNumberOfAnInteger{
    public static void main(String[] args) {
        Solution solution = new FindThePunishmentNumberOfAnInteger().new Solution();
//        System.out.println(solution.pickGifts(new int[]{25,64,9,4,100},4));
        System.out.println(solution.lengthOfLongestSubsequence(Arrays.asList(1,1,5,4,5), 3));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int punishmentNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i * i, i)) {
                result += i * i;
            }
        }
        return result;
    }
    public boolean check(int res, int target) {
        if (res == target) {
            return true;
        }
        int temp = 10;
        while (res >= temp) {
            if (check(res / temp, target - (res % temp))) {
                return true;
            }
            temp *= 10;
        }
        return false;
    }
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) ->  b - a );
        long sum = 0;
        for (int i : gifts) {
            sum += i;
            queue.add(i);
        }
        for (int i = 0; i < k; i++) {
            int current = queue.poll();
            int result = (int) Math.sqrt(current);
            sum -= current - result;
            queue.add(result);
        }
        return sum;

    }
    int mod = 1_000_000_007;
    public int sumCounts(List<Integer> nums) {
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                result =(result + getResult(nums, i, j)) % mod;
            }
        }
        return result;
    }
    public int getResult(List<Integer> nums, int i, int j) {
        Set<Integer> count = new HashSet<>();
        for (int index = i; index <= j; index++) {
            count.add(nums.get(index));
        }
        return (int)((1l * count.size() * count.size()) % mod);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[] l = new int[target + 1];
        Arrays.fill(l, -1);
        l[0] = 0;
        for (int i = 1; i <= n; i++) {
            int current = nums.get(i - 1);
            for (int j = target; j >= current; j--) {
                l[j] = Math.max(l[j], l[j - current] == 0 ? 0 : (l[j - current] + 1));
            }
        }
        return l[target] == 0 ? -1 : l[target];
     }
}
//leetcode submit region end(Prohibit modification and deletion)

}