//给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足： 
//
// 
// p[0] = start 
// p[i] 和 p[i+1] 的二进制表示形式只有一位不同 
// p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同 
// 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, start = 3
//输出：[3,2,0,1]
//解释：这个排列的二进制表示是 (11,10,00,01)
//     所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
// 
//
// 示例 2： 
//
// 输出：n = 3, start = 2
//输出：[2,6,7,5,4,0,1,3]
//解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 16 
// 0 <= start < 2^n 
// 
//
// Related Topics 位运算 数学 回溯 👍 115 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author  YourName
 * @date 2023-02-23 22:07:50
 */
public class CircularPermutationInBinaryRepresentation{
    public static void main(String[] args) {
        Solution solution = new CircularPermutationInBinaryRepresentation().new Solution();
        System.out.println(solution.circularPermutation(2,3));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] currentArray;
        int max;
        int n;
    public List<Integer> circularPermutation(int n, int start) {
        max = 1 << n;
        currentArray = new int[max];
        Arrays.fill(currentArray, -1);
        currentArray[0] = start;
        this.n = n;
        boolean[] used = new boolean[max];
        used[start] = true;
        check(used, start, 1);
        return Arrays.stream(currentArray).boxed().collect(Collectors.toList());
    }
    public boolean check(boolean[] used, int pre, int index) {
        if (index == max) {
            int temp = currentArray[0] ^ currentArray[max - 1];
            return (temp & (temp - 1)) == 0;
        }
        for (int i = 0; i < n; i++) {
            int current = 0;
            if ((pre & (1 << i)) != 0) {
                current = pre ^ (1 << i);
            } else {
                current = pre | (1 << i);
            }
            if (!used[current]) {
                used[current] = true;
                currentArray[index] = current;
                if (check(used, current, index + 1)) {
                    return true;
                }
                used[current] = false;
                currentArray[index] = -1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}