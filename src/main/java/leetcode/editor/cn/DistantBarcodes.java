//在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。 
//
// 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：barcodes = [1,1,1,2,2,2]
//输出：[2,1,2,1,2,1]
// 
//
// 示例 2： 
//
// 
//输入：barcodes = [1,1,1,1,2,2,3,3]
//输出：[1,3,1,3,2,1,2,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= barcodes.length <= 10000 
// 1 <= barcodes[i] <= 10000 
// 
//
// Related Topics 贪心 数组 哈希表 计数 排序 堆（优先队列） 👍 132 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-05-14 12:19:14
 */
public class DistantBarcodes{
    public static void main(String[] args) {
        Solution solution = new DistantBarcodes().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : barcodes) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] result = new int[barcodes.length];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> {
            return b[1] - a[1];
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        for (int i = 0; i < result.length; i++) {
            List<int[]> temp = new ArrayList<>();
            while (i != 0 && result[i - 1] == priorityQueue.peek()[0]) {
                temp.add(priorityQueue.poll());
            }
            int[] current = priorityQueue.poll();
            if (--current[1] != 0) {
                priorityQueue.add(current);
            }
            result[i] = current[0];
            for (int[] c : temp) {
                priorityQueue.add(c);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}