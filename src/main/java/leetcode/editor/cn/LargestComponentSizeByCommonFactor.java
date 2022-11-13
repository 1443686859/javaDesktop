//给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图： 
//
// 
// 有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记； 
// 只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边。 
// 
//
// 返回 图中最大连通组件的大小 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：nums = [4,6,15,35]
//输出：4
// 
//
// 示例 2： 
//
// 
//
// 
//输入：nums = [20,50,9,63]
//输出：2
// 
//
// 示例 3： 
//
// 
//
// 
//输入：nums = [2,3,6,7,4,12,21,39]
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 10⁵ 
// nums 中所有值都 不同 
// 
//
// Related Topics 并查集 数组 数学 👍 116 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  YourName
 * @date 2022-07-30 13:48:54
 */
public class LargestComponentSizeByCommonFactor{
    public static void main(String[] args) {
        Solution solution = new LargestComponentSizeByCommonFactor().new Solution();
        System.out.println(solution.largestComponentSize(new int[]{2,3,6,7,4,12,21,39}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] parent;

    public int largestComponentSize(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int current = nums[i];
            max = Math.max(max, current);
            for (int j = 2; j *j <= current; j++) {
                if (current % j == 0) {
                    List<Integer> currentList = map.getOrDefault(j, new ArrayList<>());
                    currentList.add(i);
                    map.put(j, currentList);
                    while (current % j == 0) {
                        current /= j;
                    }
                }
            }
            if (current > 1) {
                List<Integer> currentList = map.getOrDefault(current, new ArrayList<>());
                currentList.add(i);
                map.put(current, currentList);
            }
        }
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (Integer key : map.keySet()) {
            List<Integer> currentList = map.get(key);
            int defaultParent = currentList.get(0);
            for (int i = 1; i < currentList.size(); i++) {
                union(defaultParent, currentList.get(i));
            }
        }
        int[] count = new int[max + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int resultI = find(i);
            count[resultI]++;
            ans = Math.max(ans, count[resultI]);
        }
        return ans;
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY) {
            return;
        }
        parent[parentX] = parent[parentY];
    }
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}