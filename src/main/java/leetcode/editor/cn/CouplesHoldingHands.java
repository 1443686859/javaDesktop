//n 对情侣坐在连续排列的 2n 个座位上，想要牵到对方的手。 
//
// 人和座位由一个整数数组 row 表示，其中 row[i] 是坐在第 i 个座位上的人的 ID。情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 
//3)，以此类推，最后一对是 (2n-2, 2n-1)。 
//
// 返回 最少交换座位的次数，以便每对情侣可以并肩坐在一起。 每次交换可选择任意两人，让他们站起来交换座位。 
//
// 
//
// 示例 1: 
//
// 
//输入: row = [0,2,1,3]
//输出: 1
//解释: 只需要交换row[1]和row[2]的位置即可。
// 
//
// 示例 2: 
//
// 
//输入: row = [3,2,0,1]
//输出: 0
//解释: 无需交换座位，所有的情侣都已经可以手牵手了。
// 
//
// 
//
// 提示: 
//
// 
// 2n == row.length 
// 2 <= n <= 30 
// n 是偶数 
// 0 <= row[i] < 2n 
// row 中所有元素均无重复 
// 
//
// Related Topics 贪心 深度优先搜索 广度优先搜索 并查集 图 👍 435 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-11-11 00:48:27
 */
public class CouplesHoldingHands{
    public static void main(String[] args) {
        Solution solution = new CouplesHoldingHands().new Solution();
        System.out.println(solution.stringCount(10));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] parent;
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        parent = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i+=2) {
            if (row[i] / 2 != row[i + 1] / 2) {
                merge(getParent(row[i]/ 2, parent), getParent(row[i + 1] / 2, parent), parent);
            }
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : parent) {
            if (i != -1) {
                int pa = getParent(i, parent);
                countMap.put(pa, countMap.getOrDefault(pa, 0) + 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            result += entry.getValue() - 1;
        }

        return result;
    }

    public int getParent(int index, int[] parent) {
        if (parent[index] == index) {
            return index;
        }
        parent[index] = getParent(parent[index], parent);
        return parent[index];
    }
    public void merge(int pre, int after, int[] parent) {
        int pa1 = getParent(pre, parent);
        int pa2 = getParent(after, parent);
        if (pa1 != pa2) {
            parent[pa1] = pa2;
        }
    }
    public int stringCount(int n) {
        check(n, 0, new int[26]);
        return (int)count;
    }
    long count = 0;
    public void check(int end, int n, int[] map) {
       if (n == end) {
           if (map['l' -'a'] >= 1 && map['t' -'a'] >= 1 && map['e' - 'a']>= 2) {
               count++;
           }
           return ;
       }
       for (int i = 0; i < 26; i++) {
           map[i]++;
           check(end, n + 1, map);
           map[i]--;
       }

    }
    long sum = 0;
    long[][] memo;
    public long distributeCandies(int n, int limit) {
        memo = new long[3][n + 1];
        for (int i =0 ;i < 3; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, n, limit);
    }

    public long dfs(int current,int sum, int limit) {
        if ((3 - current) * limit < sum) {
            return 0;
        }
        if (current == 2) {
            if (sum <= limit) {
                return 1;
            } else {
                return 0;
            }
        }
        if (memo[current][sum] != -1) {
            return memo[current][sum];
        }
        long result = 0;
        int max = Math.min(limit, sum);
        for (int i = 0; i <= max; i++) {
            result += dfs(current + 1, sum - i, limit);
        }
        memo[current][sum] = result;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}