//给你一个无向图，无向图由整数 n ，表示图中节点的数目，和 edges 组成，其中 edges[i] = [ui, vi] 表示 ui 和 vi 之间有一条
//无向边。同时给你一个代表查询的整数数组 queries 。 
//
// 第 j 个查询的答案是满足如下条件的点对 (a, b) 的数目： 
//
// 
// a < b 
// cnt 是与 a 或者 b 相连的边的数目，且 cnt 严格大于 queries[j] 。 
// 
//
// 请你返回一个数组 answers ，其中 answers.length == queries.length 且 answers[j] 是第 j 个查询的答
//案。 
//
// 请注意，图中可能会有 重复边 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4, edges = [[1,2],[2,4],[1,3],[2,3],[2,1]], queries = [2,3]
//输出：[6,5]
//解释：每个点对中，与至少一个点相连的边的数目如上图所示。
//answers[0] = 6。所有的点对(a, b)中边数和都大于2，故有6个；
//answers[1] = 5。所有的点对(a, b)中除了(3,4)边数等于3，其它点对边数和都大于3，故有5个。
// 
//
// 示例 2： 
//
// 
//输入：n = 5, edges = [[1,5],[1,5],[3,4],[2,5],[1,3],[5,1],[2,3],[2,5]], queries =
// [1,2,3,4,5]
//输出：[10,10,9,8,6]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 2 * 10⁴ 
// 1 <= edges.length <= 10⁵ 
// 1 <= ui, vi <= n 
// ui != vi 
// 1 <= queries.length <= 20 
// 0 <= queries[j] < edges.length 
// 
//
// Related Topics 图 数组 双指针 二分查找 排序 👍 137 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-08-23 20:59:42
 */
public class CountPairsOfNodes{
    public static void main(String[] args) {
        Solution solution = new CountPairsOfNodes().new Solution();
        System.out.println(solution.minGroupsForValidAssignment(new int[]{3,2,3,2,3}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countPairs1(int n, int[][] edges, int[] queries) {
        int[] d = new int[n + 1];
       
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            d[edge[0]] ++;
            d[edge[1]]++;
            int x = edge[0];
            int y = edge[1];
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            int key = x << 16 | y;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int[] ans = new int[queries.length];
        int[] clone = d.clone();
        Arrays.sort(clone);
        for (int i = 0; i < queries.length; i++) {
            int left = 1;
            int right = n;
            int current = queries[i];
            while (left < right) {
                if (clone[left] + clone[right] <= current) {
                    left++;
                } else {
                    ans[i] += right - left;
                    right--;
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int k = entry.getKey();
                int v = entry.getValue();
                int currentSum = d[k >> 16] + d[k & ((1 << 16) - 1)];
                if (currentSum > current && currentSum - v <= current) {
                    ans[i] --;
                }
            }
        }
        return ans;
    }
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] d = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            d[edge[0]] ++;
            d[edge[1]]++;
            int x = edge[0];
            int y = edge[1];
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            int key = x << 16 | y;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = 0;
        for (int i = 1; i <= n; i++) {
            countMap.merge(d[i], 1, Integer::sum);
            max = Math.max(max, d[i]);
        }
        int[] countSum = new int[2 * (max + 1)];
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int degree1 = entry.getKey();
            int count1 = entry.getValue();
            for (Map.Entry<Integer, Integer> entry1 : countMap.entrySet()) {
                int degree2 = entry1.getKey();
                int count2 = entry1.getValue();
                if (degree1 < degree2) {
                    countSum[degree1 + degree2] += count2 * count1;
                } else if (degree2 == degree1) {
                    countSum[degree1 + degree2] += (count1 - 1) * count1 / 2;
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            int currentSum = d[k >> 16] + d[k & 0xffff];
            countSum[currentSum] --;
            countSum[currentSum - v] ++;
        }
        for (int i = countSum.length - 1; i > 0; i--) {
            countSum[i - 1] += countSum[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = countSum[Math.min(queries[i] + 1, countSum.length - 1)];
        }
        return ans;
    }

    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (int i : count.values()) {
            max = Math.max(i, max);
        }
        int result = 0;
        while ((result = check(count, max)) == -1 && max >= 0) {
            max--;
        }
        return result;
    }
    public int check(Map<Integer, Integer> map, int max) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            if (v < max - 1) {
                return - 1;
            } else if (v == max - 1) {
                result ++;
                continue;
            }
            if (v >= max) {
                int res = v % max;
                int c = v / max;
                if (res != 0 && max - 1 - res > c) {
                    return -1;
                }
                result += c + (res != 0 ? 1 : 0);
            }

        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}