//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件： 
//
// 
// 只使用数字1到9 
// 每个数字 最多使用一次 
// 
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。 
//
// 示例 2: 
//
// 
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。 
//
// 示例 3: 
//
// 
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
// 
//
// 
//
// 提示: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
//
// Related Topics 数组 回溯 👍 821 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-04-21 00:15:53
 */
public class CombinationSumIii{
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
        System.out.println(solution.combinationSum3(3,7));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result;
    int max;
    public List<List<Integer>> combinationSum3(int k, int n) {
        max = k;
        result = new ArrayList<>();
        dfs(new ArrayList<>(), n, 0, 0, 0);
        return result;
    }

    public void dfs(List<Integer> temp, int rest, int start, int used, int nextStart) {
        if (rest == 0 && start == max) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (rest < 0 || start >= max) {
            return;
        }
        for (int i = nextStart + 1; i <= 9; i++) {
            if ((used & (1<< i)) == 0 && rest >= i) {
                temp.add(i);
                dfs(temp, rest - i, start + 1, used | 1 << i, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}