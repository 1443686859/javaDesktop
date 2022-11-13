package leetcode.editor.cn;
//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 843 👎 0

import java.util.Arrays;

public class P264UglyNumberIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    public int nthUglyNumber(int n) {
        int[] points = new int[3];
        int[] current = new int[]{2,3,5};
        int[] result = new int[n + 1];
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Math.min(Math.min(result[points[0] + 1] * 2,  result[points[1] + 1] * 3), result[points[2] + 1] * 5);
            if (min == result[points[0] + 1] * 2) {
                points[0]++;
            }
            if (min == result[points[1] + 1] * 3) {
                points[1]++;
            }
            if (min == result[points[2] + 1] * 5) {
                points[2]++;
            }
     /*
     // 不用循环的理由是如果每个points[i]同时取得最小值的话，只会更新最后一个points,
     // 这是错误的，同时取得并不影响第n个丑数的取值，需要越过这个时候最小值，必须都要更新
     int minIndex = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (min > current[j] * result[points[j] + 1]) {
                    min = current[j] * result[points[j] + 1];
                    minIndex = j;
                }

            }
            points[minIndex]++;*/

            result[i] = min;
        }
        return result[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}