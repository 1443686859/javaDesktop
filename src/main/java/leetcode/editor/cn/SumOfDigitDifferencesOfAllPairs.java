/**
你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。 

 两个整数的 数位差 指的是两个整数 相同 位置上不同数字的数目。 

 请你返回 nums 中 所有 整数对里，数位差之和。 

 

 示例 1： 

 
 输入：nums = [13,23,12] 
 

 输出：4 

 解释： 计算过程如下： - 13 和 23 的数位差为 1 。 - 13 和 12 的数位差为 1 。 - 23 和 12 的数位差为 2 。 所以所有整数数
对的数位差之和为 1 + 1 + 2 = 4 。 

 示例 2： 

 
 输入：nums = [10,10,10,10] 
 

 输出：0 

 解释： 数组中所有整数都相同，所以所有整数数对的数位不同之和为 0 。 

 

 提示： 

 
 2 <= nums.length <= 10⁵ 
 1 <= nums[i] < 10⁹ 
 nums 中的整数都有相同的数位长度。 
 

 👍 44 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2024-08-30 21:17:23
 */
public class SumOfDigitDifferencesOfAllPairs{
    public static void main(String[] args) {
        Solution solution = new SumOfDigitDifferencesOfAllPairs().new Solution();
        System.out.println(solution.minDamage(4, new int[]{1,2,3,4}, new int[]{4,5,6,8}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long sumDigitDifferences(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i : nums) {
            deque.add(i);
        }
        long result = 0;
        int n = nums.length;
        while (true) {
            boolean isBreak = false;
            int[] count = new int[10];
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    isBreak = true;
                    break;
                }
                count[nums[i] % 10]++;
                nums[i] /= 10;
            }
            int temp = n;
            for (int i : count) {
                if (i != 0) {
                    result += 1l * (temp - i) * i;
                }
                temp -= i;
            }
            if (isBreak)
            break;
        }
        return result;
    }
    public long minDamage(int power, int[] damage, int[] health) {
        int[][] index = new int[damage.length][2];
        long sum = 0;
        for (int i = 0; i < damage.length;i++) {
            index[i][0] = damage[i];
            index[i][1] = (health[i] + power - 1) / power;
            sum += damage[i];
        }
        Arrays.sort(index, (a, b) -> {
            return b[0] * a[1] - a[0] * b[1];
        });
        long result = 0;
        for (int i = 0; i < damage.length; i++) {
            result += sum * index[i][1];
            sum -= index[i][0];
        }
        return result;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}