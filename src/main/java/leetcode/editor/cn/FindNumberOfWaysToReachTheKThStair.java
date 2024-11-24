/**
给你有一个 非负 整数 k 。有一个无限长度的台阶，最低 一层编号为 0 。 

 虎老师有一个整数 jump ，一开始值为 0 。虎老师从台阶 1 开始，虎老师可以使用 任意 次操作，目标是到达第 k 级台阶。假设虎老师位于台阶 i ，一次
 操作 中，虎老师可以： 

 
 向下走一级到 i - 1 ，但该操作 不能 连续使用，如果在台阶第 0 级也不能使用。 
 向上走到台阶 i + 2ʲᵘᵐᵖ 处，然后 jump 变为 jump + 1 。 
 

 请你返回虎老师到达台阶 k 处的总方案数。 

 注意 ，虎老师可能到达台阶 k 处后，通过一些操作重新回到台阶 k 处，这视为不同的方案。 

 

 示例 1： 

 
 输入：k = 0 
 

 输出：2 

 解释： 

 2 种到达台阶 0 的方案为： 

 
 虎老师从台阶 1 开始。 
 
 执行第一种操作，从台阶 1 向下走到台阶 0 。 
 
 虎老师从台阶 1 开始。 
 
 执行第一种操作，从台阶 1 向下走到台阶 0 。 
 执行第二种操作，向上走 2⁰ 级台阶到台阶 1 。 
 执行第一种操作，从台阶 1 向下走到台阶 0 。 
 
 

 示例 2： 

 
 输入：k = 1 
 

 输出：4 

 解释： 

 4 种到达台阶 1 的方案为： 

 
 虎老师从台阶 1 开始，已经到达台阶 1 。 
 虎老师从台阶 1 开始。 
 
 执行第一种操作，从台阶 1 向下走到台阶 0 。 
 执行第二种操作，向上走 2⁰ 级台阶到台阶 1 。 
 
 虎老师从台阶 1 开始。 
 
 执行第二种操作，向上走 2⁰ 级台阶到台阶 2 。 
 执行第一种操作，向下走 1 级台阶到台阶 1 。 
 
 虎老师从台阶 1 开始。 
 
 执行第一种操作，从台阶 1 向下走到台阶 0 。 
 执行第二种操作，向上走 2⁰ 级台阶到台阶 1 。 
 执行第一种操作，向下走 1 级台阶到台阶 0 。 
 执行第二种操作，向上走 2¹ 级台阶到台阶 2 。 
 执行第一种操作，向下走 1 级台阶到台阶 1 。 
 
 

 

 提示： 

 
 0 <= k <= 10⁹ 
 

 👍 8 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2024-05-21 20:28:29
 */
public class FindNumberOfWaysToReachTheKThStair{
    public static void main(String[] args) {
        Solution solution = new FindNumberOfWaysToReachTheKThStair().new Solution();
        System.out.println(solution.waysToReachStair(1048556));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int target;
        Map<Long, Integer> memo;
    public int waysToReachStair( int k) {
        if (k == 0) {
            return 2;
        }
        int target = k - 1;
        int n = 32 - Integer.numberOfLeadingZeros(target);
        int max = 1 << n;
        long ans = 0;
        while (n + 1 >= (max - target - 1)) {
            ans +=  c(n + 1, (max - target - 1));
            max <<= 1;
            n++;
        }
        return (int) ans;
//        target = k;
//        memo = new HashMap<>();
//        return dfs(1, 0, 0);
    }
    public long c(int n, int k) {
        long ans = 1;
        for (int i = 1, j = n - k + 1; j <=n; i++, j++) {
            ans = ans * j / i;
        }
        return (int) ans;
    }

    public int dfs(int k, int j, int pre) {
        if (k > target + 1) {
            return 0;
        }
        long key = ((long)k << 32) | (long) j << 1| pre;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int result = dfs(k + (1 << j), j + 1, 0) + (k == target ? 1 : 0);
        if (pre == 0 && k > 0)  {
            result += dfs(k - 1, j, 1);
        }
        memo.put(key, result);
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}