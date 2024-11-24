//给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。 
//
// 你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。 
//
// 
//
// 示例 1： 
//
// 输入：mat = [[1,3,11],[2,4,6]], k = 5
//输出：7
//解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
//[1,2], [1,4], [3,2], [3,4], [1,6]。其中第 5 个的和是 7 。  
//
// 示例 2： 
//
// 输入：mat = [[1,3,11],[2,4,6]], k = 9
//输出：17
// 
//
// 示例 3： 
//
// 输入：mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
//输出：9
//解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
//[1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]。其中第 7 个的和是 9 。 
// 
//
// 示例 4： 
//
// 输入：mat = [[1,1,10],[2,2,9]], k = 7
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat.length[i] 
// 1 <= m, n <= 40 
// 1 <= k <= min(200, n ^ m) 
// 1 <= mat[i][j] <= 5000 
// mat[i] 是一个非递减数组 
// 
//
// Related Topics 数组 二分查找 矩阵 堆（优先队列） 👍 137 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en


import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author  YourName
 * @date 2023-05-28 12:15:58
 */
public class FindTheKthSmallestSumOfAMatrixWithSortedRows{
    public static void main(String[] args) {
        Solution solution = new FindTheKthSmallestSumOfAMatrixWithSortedRows().new Solution();
//        System.out.println(solution.kthSmallest(new int[][]{{1,3,11},{2,4,6}}, 9));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int kthSmallest(int[][] mat, int k) {
//        int n = mat.length;
//        int m = mat[0].length;
//        int min = 0;
//        StringBuilder mask = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            min += mat[i][0];
//            mask.append("00");
//        }
//        PriorityQueue<Pair<Integer, String>> priorityQueue = new PriorityQueue<>((pre, after) -> {
//            return pre.getKey() - after.getKey();
//        });
//        Set<String> used = new HashSet<>();
//        used.add(mask.toString());
//        priorityQueue.add(new Pair<>(min, mask.toString()));
//        int current = 1;
//       while (current < k && !priorityQueue.isEmpty()) {
//            Pair<Integer, String> currentP = priorityQueue.poll();
//            for (int i = 0; i < n; i++) {
//                String currentMask = currentP.getValue();
//                int currentIndex = Integer.parseInt(currentMask.substring(2 * i, 2 * (i + 1)));
//                int currentMin = currentP.getKey() - mat[i][currentIndex];
//                if (currentIndex == m - 1) {
//                    continue;
//                }
//                currentIndex++;
//                String newMask = currentMask.substring(0, 2 * i) + String.format("%02d", currentIndex) + currentMask.substring(2  * (i + 1));
//                if (!used.add(newMask)) {
//                    continue;
//                }
//                currentMin += mat[i][currentIndex];
//                priorityQueue.add(new Pair<>(currentMin, newMask));
//            }
//            current++;
//        }
//        return priorityQueue.peek().getKey();

//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}