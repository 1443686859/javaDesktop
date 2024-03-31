//在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。 
//
// 给定一个由整数坐标组成的数组 queens ，表示黑皇后的位置；以及一对坐标 king ，表示白国王的位置，返回所有可以攻击国王的皇后的坐标(任意顺序)。
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
//输出：[[0,1],[1,0],[3,3]]
//解释： 
//[0,1] 的皇后可以攻击到国王，因为他们在同一行上。 
//[1,0] 的皇后可以攻击到国王，因为他们在同一列上。 
//[3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。 
//[0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。 
//[4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。 
//[2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
//输出：[[2,2],[3,4],[4,4]]
// 
//
// 示例 3： 
//
// 
//
// 
//输入：queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3]
//,[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[
//0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
//输出：[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= queens.length <= 63 
// queens[i].length == 2 
// 0 <= queens[i][j] < 8 
// king.length == 2 
// 0 <= king[0], king[1] < 8 
// 一个棋盘格上最多只能放置一枚棋子。 
// 
//
// Related Topics 数组 矩阵 模拟 👍 111 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-09-14 20:57:17
 */
public class QueensThatCanAttackTheKing{
    public static void main(String[] args) {
        Solution solution = new QueensThatCanAttackTheKing().new Solution();
        System.out.println(solution.countWays(Arrays.asList(5,0,3,4,2,1,2,4)));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int count = nums.get(0) > 0 ? 1 : 0;
        int length = 0;
        int[] c = new int[nums.size() + 1];
        int pre = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            c[i]++;
            if (i != pre) {
                map.put(pre, i);
                pre = i;
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            if (c[i] !=0) {
                if (i < length + c[i] && map.getOrDefault(i, nums.size() + 1) > length + c[i]) {
                    count++;
                }
                length += c[i];
            }
        }
        return count;
    }
    public int minLengthAfterRemovals(List<Integer> nums) {
        boolean[] used = new boolean[nums.size()];
        int pre = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (used[i]) {
                continue;
            }
            if (pre == nums.size()) {
                break;
            }
            while (pre == -1 || (pre < nums.size() && (used[pre] || nums.get(pre) <= nums.get(i)))) {
                pre ++;
            }
            if (pre < nums.size() && pre > i) {
                used[i] = true;
                used[pre] = true;
            }
        }
        int count = 0;
        for (boolean c : used) {
            if (c == false) {
                count++;
            }
        }
        return count;
    }
        List<List<Integer>> result;
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<Integer> count = new ArrayList<>();
        for (int[] q : queens) {
            count.add(q[0] * 8 + q[1]);
        }
        result = new ArrayList<>();
        int[] d = new int[]{1, -1, 0};
        for (int i = 0; i < d.length; i++) {
            for (int j =0 ;j < d.length; j++) {
                if (d[i] == d[j] && d[j] == 0) {
                    continue;
                }
                search(new int[]{d[i],d[j]}, count, king[0], king[1], 8);
            }
        }
        return result;
    }
    public void search(int[] current, List<Integer> count, int x, int y, int max) {
        while (true) {
            x += current[0];
            y += current[1];
            if (x < 0 || x >= max || y < 0 || y >= max) {
                break;
            }
            if (count.contains(x * max + y)) {
                result.add(Arrays.asList(x, y));
                break;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}