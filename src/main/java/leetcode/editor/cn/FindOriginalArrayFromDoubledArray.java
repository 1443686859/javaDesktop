//一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有
//元素 随机打乱 。 
//
// 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 
//任意 顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：changed = [1,3,4,2,6,8]
//输出：[1,3,4]
//解释：一个可能的 original 数组为 [1,3,4] :
//- 将 1 乘以 2 ，得到 1 * 2 = 2 。
//- 将 3 乘以 2 ，得到 3 * 2 = 6 。
//- 将 4 乘以 2 ，得到 4 * 2 = 8 。
//其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
// 
//
// 示例 2： 
//
// 输入：changed = [6,3,0,1]
//输出：[]
//解释：changed 不是一个双倍数组。
// 
//
// 示例 3： 
//
// 输入：changed = [1]
//输出：[]
//解释：changed 不是一个双倍数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= changed.length <= 10⁵ 
// 0 <= changed[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 哈希表 排序 👍 58 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-04-18 20:16:47
 */
public class FindOriginalArrayFromDoubledArray{
    public static void main(String[] args) {
        Solution solution = new FindOriginalArrayFromDoubledArray().new Solution();
        System.out.println(solution.findOriginalArray(new int[]{1,3,4,2,6,8}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOriginalArray(int[] changed) {

        Map<Integer, Integer> count = new HashMap<>(changed.length);
        for (int i : changed) {
            count.merge(i, 1, Integer::sum);
        }
        int count0 = count.getOrDefault(0, 0);
        if (count0 % 2 == 1) {
            return new int[0];
        }
        int start = count0 / 2;
        count.remove(0);
        int[] result = new int[changed.length/ 2];
        for (int i : count.keySet()) {
            if ((i & 1)== 0 && count.containsKey(i / 2)) {
                continue;
            }
            while (count.containsKey(i)) {
                int count2 = count.getOrDefault(2 * i, 0);
                int c = count.get(i);
                if (c > count2) {
                    return new int[0];
                }
                for (int j = 0; j < c; j ++) {
                    result[start ++] = i;
                }
                if (c < count2) {
                    count.put(2 * i, count2 - c);
                    i *= 2;
                } else {
                    i *= 4;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}