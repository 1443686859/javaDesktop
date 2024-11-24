/**
给你一个整数 n 和一个二维整数数组 queries。 

 有 n 个城市，编号从 0 到 n - 1。初始时，每个城市 i 都有一条单向道路通往城市 i + 1（ 0 <= i < n - 1）。 

 queries[i] = [ui, vi] 表示新建一条从城市 ui 到城市 vi 的单向道路。每次查询后，你需要找到从城市 0 到城市 n - 1 的最短路
径的长度。 

 返回一个数组 answer，对于范围 [0, queries.length - 1] 中的每个 i，answer[i] 是处理完前 i + 1 个查询后，从城
市 0 到城市 n - 1 的最短路径的长度。 

 

 示例 1： 

 
 输入： n = 5, queries = [[2, 4], [0, 2], [0, 4]] 
 

 输出： [3, 2, 1] 

 解释： 

 

 新增一条从 2 到 4 的道路后，从 0 到 4 的最短路径长度为 3。 

 

 新增一条从 0 到 2 的道路后，从 0 到 4 的最短路径长度为 2。 

 

 新增一条从 0 到 4 的道路后，从 0 到 4 的最短路径长度为 1。 

 示例 2： 

 
 输入： n = 4, queries = [[0, 3], [0, 2]] 
 

 输出： [1, 1] 

 解释： 

 

 新增一条从 0 到 3 的道路后，从 0 到 3 的最短路径长度为 1。 

 

 新增一条从 0 到 2 的道路后，从 0 到 3 的最短路径长度仍为 1。 

 

 提示： 

 
 3 <= n <= 500 
 1 <= queries.length <= 500 
 queries[i].length == 2 
 0 <= queries[i][0] < queries[i][1] < n 
 1 < queries[i][1] - queries[i][0] 
 查询中没有重复的道路。 
 

 👍 58 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-11-19 23:38:16
 */
public class ShortestDistanceAfterRoadAdditionQueriesI{
    public static void main(String[] args) {
        Solution solution = new ShortestDistanceAfterRoadAdditionQueriesI().new Solution();
        System.out.println(solution.shortestDistanceAfterQueries(5, new int[][] {
                {2,4},{0,2},{0,4}
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] list = new List[n];
        Arrays.setAll(list, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            list[i].add(i + 1);
        }
        int index = 0;
        int[] ans = new int[queries.length];
        for (int[] query : queries) {
            list[query[0]].add(query[1]);
            ans[index] = bfs(0, list);
            index++;
        }
        return ans;
    }
    public int bfs(int start, List<Integer>[] list) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        int[] visited = new int[list.length];
        Arrays.fill(visited, -1);
        visited[0] = 0;
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0;i < size; i++) {
                int current = deque.pollFirst();
                visited[current] = count;
                if (current== list.length - 1) {
                    return count;
                }
                for (int j : list[current]) {
                    if (visited[j] == -1) {
                        deque.addLast(j);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}