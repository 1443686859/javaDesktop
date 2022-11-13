package leetcode.editor.cn;
//我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。 
//
// 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。 
//
// 
//
// 示例 1： 
//
// 输出：low = 100, high = 300
//输出：[123,234]
// 
//
// 示例 2： 
//
// 输出：low = 1000, high = 13000
//输出：[1234,2345,3456,4567,5678,6789,12345]
// 
//
// 
//
// 提示： 
//
// 
// 10 <= low <= high <= 10^9 
// 
// Related Topics 枚举 👍 37 👎 0

import java.util.ArrayList;
import java.util.List;

public class P1291SequentialDigits{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sequentialDigits(10,
                1000000000));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> resultList = new ArrayList<>();
        int lowMin = low;
        int lowCount = 0;
        while (lowMin != 0) {
            lowCount++;
            lowMin /= 10;
        }
        int highMax = high;
        int highCount = 0;
        while (highMax != 0) {
            highCount++;
            highMax /= 10;
        }
        int start = 0;
        int startOne = 1;
        for (int i = 0; i < lowCount; i++) {
            start = start * 10 + startOne;
            startOne ++;
        }
        while (start < low) {
            start = start % fastPow(10, lowCount - 1) * 10 + startOne;
            startOne++;
        }
        int currentCount = lowCount;
        while (start >= low && start <= high && currentCount <= highCount) {
            resultList.add(start);
            start = start % fastPow(10, currentCount - 1) * 10+ startOne;
            if (startOne > 9) {
                currentCount++;
                startOne= 1;
                start = 0;
                for (int i = 0; i < currentCount; i++) {
                    start = start * 10 + startOne;
                    startOne ++;
                }
                continue;
            }
            startOne++;

        }
        return resultList;
    }
    int fastPow(int base, int n) {
        int baseOne = base;
        int result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                result *= baseOne;
            }
            baseOne *= baseOne;
            n >>= 1;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}