//在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。 
//
// red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从
//节点 i 到节点 j 的蓝色有向边。 
//
// 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，
//那么 answer[x] = -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
//输出：[0,1,-1]
// 
//
// 示例 2： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
//输出：[0,1,-1]
// 
//
// 示例 3： 
//
// 
//输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
//输出：[0,-1,-1]
// 
//
// 示例 4： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
//输出：[0,1,2]
// 
//
// 示例 5： 
//
// 
//输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
//输出：[0,1,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// red_edges.length <= 400 
// blue_edges.length <= 400 
// red_edges[i].length == blue_edges[i].length == 2 
// 0 <= red_edges[i][j], blue_edges[i][j] < n 
// 
//
// Related Topics 广度优先搜索 图 👍 208 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-02-02 19:17:14
 */
public class ShortestPathWithAlternatingColors{
    public static void main(String[] args) {
        Solution solution = new ShortestPathWithAlternatingColors().new Solution();
        System.out.println(solution.shortestAlternatingPaths(3, new int[][]{{0,1},{1,2}}, new int[0][0]));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        List<Integer>[] red = new List[n];
        List<Integer>[] blue = new List[n];
        for (int i = 0; i < n; i++) {
            red[i] = new ArrayList<>();
            blue[i] = new ArrayList<>();
        }
        for (int[] redE : redEdges) {
            red[redE[0]].add(redE[1]);
        }
        for (int[] redE : blueEdges) {
            blue[redE[0]].add(redE[1]);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        boolean startBlue = true;
        Set<Integer> visited = new HashSet<>();
        Set<Integer> bVisited = new HashSet<>();
        int length = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int current = deque.poll();
                ans[current] = Math.min(ans[current], length);
                if (startBlue) {
                    for (int c : blue[current]) {
                        if (!bVisited.contains(c)) {
                            deque.offer(c);
                            bVisited.add(c);
                        }
                    }
                } else {
                    for (int c : red[current]) {
                        if (!visited.contains(c)) {
                            deque.offer(c);
                            visited.add(c);
                        }
                    }
                }
            }
            startBlue = !startBlue;
            length++;
        }
        deque.clear();
        visited.clear();
        bVisited.clear();
        length = 0;
        deque.add(0);
        startBlue = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int current = deque.poll();
                ans[current] = Math.min(ans[current], length);
                if (startBlue) {
                    for (int c : blue[current]) {
                        if (!bVisited.contains(c)) {
                            deque.offer(c);
                            bVisited.add(c);
                        }
                    }
                } else {
                    for (int c : red[current]) {
                        if (!visited.contains(c)) {
                            deque.offer(c);
                            visited.add(c);
                        }
                    }
                }
            }
            startBlue = !startBlue;
            length++;
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }

        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}