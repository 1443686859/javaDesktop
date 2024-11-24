/**
一个非负整数 x 的 强数组 指的是满足元素为 2 的幂且元素总和为 x 的最短有序数组。下表说明了如何确定 强数组 的示例。可以证明，x 对应的强数组是独一无
二的。 

 
 
 
 数字 
 二进制表示 
 强数组 
 
 
 1 
 00001 
 [1] 
 
 
 8 
 01000 
 [8] 
 
 
 10 
 01010 
 [2, 8] 
 
 
 13 
 01101 
 [1, 4, 8] 
 
 
 23 
 10111 
 [1, 2, 4, 16] 
 
 
 

 

 我们将每一个升序的正整数 i （即1，2，3等等）的 强数组 连接得到数组 big_nums ，big_nums 开始部分为 [1, 2, 1, 2, 4, 
1, 4, 2, 4, 1, 2, 4, 8, ...] 。 

 给你一个二维整数数组 queries ，其中 queries[i] = [fromi, toi, modi] ，你需要计算 (big_nums[fromi] 
* big_nums[fromi + 1] * ... * big_nums[toi]) % modi 。 

 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。 

 

 示例 1： 

 输入：queries = [[1,3,7]] 

 输出：[4] 

 解释： 

 只有一个查询。 

 big_nums[1..3] = [2,1,2] 。它们的乘积为 4。结果为 4 % 7 = 4。 

 示例 2： 

 输入：queries = [[2,5,3],[7,7,4]] 

 输出：[2,2] 

 解释： 

 有两个查询。 

 第一个查询：big_nums[2..5] = [1,2,4,1] 。它们的乘积为 8 。结果为 8 % 3 = 2。 

 第二个查询：big_nums[7] = 2 。结果为 2 % 4 = 2。 

 

 提示： 

 
 1 <= queries.length <= 500 
 queries[i].length == 3 
 0 <= queries[i][0] <= queries[i][1] <= 10¹⁵ 
 1 <= queries[i][2] <= 10⁵ 
 

 

 👍 28 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-08-23 20:57:18
 */
public class FindProductsOfElementsOfBigArray{
    public static void main(String[] args) {
        Solution solution = new FindProductsOfElementsOfBigArray().new Solution();
        System.out.println(solution.findProductsOfElements(new long[][]{
                {9,9,1}
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findProductsOfElements(long[][] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        for (long[] query : queries) {
            long[] pre = find(query[0]);
            long[] after = find(query[1] + 1);
            result[index++] = (int)fastPow(2L, after[2] - pre[2], query[2]);
        }
        return result;
    }
    private long[] find(long target) {
        long right = 2 * target;
        long left = 1;
        long[] result = new long[3];
        while (left <= right) {
            long mid = (right + left) / 2;
            long[] temp = countDigitOne(mid, 1);
            if (temp[0] >= target) {
                result = new long[]{mid, temp[0],temp[1]};
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (result[1] > target) {
            int start = 64 - Long.numberOfLeadingZeros(result[0]) - 1;
            while (result[1] > target) {
                if ((result[0] & (1L << (start))) != 0) {
                    result[1]--;
                    result[2] -= start;
                }
                start--;
            }
        }
        return result;
    }
    private long[] countDigitOne(long num, int x) {
        long res = 0;
        int i = x - 1;
        long sum = 0;
        for (long n = num >> i; n > 0; n >>= x, i += x) {
            res += (n / 2) << i;
            sum += ((n / 2) << i) * i;
            if (n % 2 > 0) {
                long mask = (1L << i) - 1;
                res += (num & mask) + 1;
                sum += ((num & mask) + 1) * i;
            }
        }
        return new long[]{res, sum};
    }

        public long[] findMaximumNumber(long k, int x) {
            long num = 0;
            long pre1 = 0;
            long result = 0;
            for (long i = 63 - Long.numberOfLeadingZeros((k + 1) << x); i >= 0; i--) {
                long cnt = (pre1 << i) + (i / x << i >> 1);
                if (cnt > k) {
                    continue;
                }
                k -= cnt;
                num |= 1L << i;
                result += (1L << i) * i;
                if ((i + 1) % x == 0) {
                    pre1++;
                }
            }
            return new long[]{num - 1, result};
        }




    public long fastPow(long base, long index, long mod) {
        long result = 1;
        while (index != 0) {
            if ((index & 1) != 0) {
                result = (result * base) % mod;
            }
            index >>= 1;
            base = (base * base) % mod;
        }
        return result % mod;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}