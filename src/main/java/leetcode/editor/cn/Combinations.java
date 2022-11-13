//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 👍 1003 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2022-06-04 16:45:18
 */
public class Combinations{
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        System.out.println(solution.combine(1,1));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        Set<Integer> set;
        int m;
    public List<List<Integer>> combine(int n, int k) {
        m = n;
        set = new HashSet<>();
        dfs(k, 0, 0);
        List<List<Integer>> resultList = new ArrayList<>();
        for (Integer current : set) {
            int count = 0;
            List<Integer> currentList = new ArrayList<>();
            while (current != 0) {
                if ((current & 1) != 0) {
                    currentList.add(count + 1);
                }
                count++;
                current = current >> 1;
            }
            resultList.add(currentList);
        }
        return resultList;
    }
    public void dfs(int count, int current, int index) {
        if (count == 0) {
            set.add(current);
            return ;
        }
        if (index ==  m) {
            return;
        }
        dfs(count - 1, current |(1 << index), index+1);
        dfs(count, current, index+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}