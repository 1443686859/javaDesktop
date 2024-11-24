//给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。 
//
// 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。 
//
// 满足条件的二叉树一共有多少个？答案可能很大，返回 对 10⁹ + 7 取余 的结果。 
//
// 
//
// 示例 1: 
//
// 
//输入: arr = [2, 4]
//输出: 3
//解释: 可以得到这些二叉树: [2], [4], [4, 2, 2] 
//
// 示例 2: 
//
// 
//输入: arr = [2, 4, 5, 10]
//输出: 7
//解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2]. 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 2 <= arr[i] <= 10⁹ 
// arr 中的所有值 互不相同 
// 
//
// Related Topics 数组 哈希表 动态规划 排序 👍 186 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-08-29 19:53:48
 */
public class BinaryTreesWithFactors{
    public static void main(String[] args) {
        Solution solution = new BinaryTreesWithFactors().new Solution();
        System.out.println(solution.numFactoredBinaryTrees(new int[]{2,4,5,10}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int mod = (int)1e9 + 7;
    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            resultMap.put(arr[i], 1);
        }
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            long current = resultMap.get(arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] % arr[j] == 0) {
                    if (arr[i] / arr[j] > arr[j]) {
                        break;
                    }
                    int v = resultMap.get(arr[j]);
                    int v1 = resultMap.getOrDefault(arr[i] / arr[j], 0);
                    long currentVal = 0;
                    if (arr[i] / arr[j]== arr[j]) {
                        currentVal = ((1l * v1 * v) % mod);
                    } else {
                        currentVal = (2l * v1 * v) % mod;
                    }
                   current = (current + currentVal) % mod;
                    resultMap.put(arr[i], (int)current);
                }
            }
            ans = (ans + resultMap.get(arr[i])) % mod;
        }
        return (int) ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}