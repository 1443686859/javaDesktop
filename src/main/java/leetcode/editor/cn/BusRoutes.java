/**
给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。 

 
 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 ->
 ... 这样的车站路线行驶。 
 

 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。 

 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。 

 

 示例 1： 

 
输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
输出：2
解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。 
 

 示例 2： 

 
输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
输出：-1
 

 

 提示： 

 
 1 <= routes.length <= 500. 
 1 <= routes[i].length <= 10⁵ 
 routes[i] 中的所有值 互不相同 
 sum(routes[i].length) <= 10⁵ 
 0 <= routes[i][j] < 10⁶ 
 0 <= source, target < 10⁶ 
 

 👍 391 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-09-17 10:01:12
 */
public class BusRoutes{
    public static void main(String[] args) {
        Solution solution = new BusRoutes().new Solution();
        System.out.println(solution.numBusesToDestination(new int[][]{
                {2},{2,8}
        }, 8, 2));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.computeIfAbsent(routes[i][j],k -> new ArrayList<>()).add(i);
            }
        }
        if (!map.containsKey(source) || !map.containsKey(target))  {
            return target == source ? 0 : -1;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        Map<Integer, Integer> dis = new HashMap<>();
        dis.put(source, 0);
        while (!queue.isEmpty() ) {
            int x = queue.poll();
            int disX = dis.get(x);
            for (int i : map.get(x)) {
                if (routes[i] != null) {
                    for (int y : routes[i]) {
                        if (!dis.containsKey(y)) {
                            queue.add(y);
                            dis.put(y, disX + 1);
                        }
                    }

                }
                routes[i] = null;

            }
        }
        return dis.getOrDefault(target, -1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}