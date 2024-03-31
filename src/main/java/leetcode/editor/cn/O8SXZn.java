//给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 `i` 个水缸配备的水桶容量记作 `bucket[i]`。小扣有以下两种操作：
//- 升级水桶：选择任意一个水桶，使其容量增加为 `bucket[i]+1`
//- 蓄水：将全部水桶接满水，倒入各自对应的水缸
//
//每个水缸对应最低蓄水量记作 `vat[i]`，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
//
//注意：实际蓄水量 **达到或超过** 最低蓄水量，即完成蓄水要求。
//
//**示例 1：**
//
//> 输入：`bucket = [1,3], vat = [6,8]`
//>
//> 输出：`4`
//>
//> 解释：
//> 第 1 次操作升级 bucket[0]；
//> 第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。
//> ![vat1.gif](https://pic.leetcode-cn.com/1616122992-RkDxoL-vat1.gif)
//
//**示例 2：**
//
//> 输入：`bucket = [9,0,1], vat = [0,2,2]`
//>
//> 输出：`3`
//>
//> 解释：
//> 第 1 次操作均选择升级 bucket[1]
//> 第 2~3 次操作选择蓄水，即可完成蓄水要求。
//
//**提示：**
//- `1 <= bucket.length == vat.length <= 100`
//- `0 <= bucket[i], vat[i] <= 10^4`
//
// Related Topics 贪心 数组 堆（优先队列） 👍 167 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.PriorityQueue;

/**
 * @author  YourName
 * @date 2023-05-21 19:34:47
 */
public class O8SXZn{
    public static void main(String[] args) {
        Solution solution = new O8SXZn().new Solution();
        System.out.println(solution.storeWater(new int[]{3,2,5}, new int[]{0,0,0}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {return b[0] - a[0];});
        int base = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (vat[i] != 0) {
                if (bucket[i] == 0) {
                    base++;
                    bucket[i]++;
                }
                if (vat[i] > 0) {
                    priorityQueue.add(new int[]{(vat[i] + bucket[i] - 1) / bucket[i], i});

                }
            }
        }
        if (priorityQueue.isEmpty()) {
            return base;
        }
        int min = Integer.MAX_VALUE;
        while (base < min) {
            int[] current = priorityQueue.poll();
            min = Math.min(min, current[0] + base);
            if (current[0] == 1) {
                break;
            }
            int index = current[1];
            base++;
            bucket[index]++;
            priorityQueue.add(new int[] {(vat[index] + bucket[index] - 1) / bucket[index], index});
        }
        return min ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}