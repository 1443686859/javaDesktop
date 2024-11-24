/**
在 LeetCode 商店中， 有 n 件在售的物品。每件物品都有对应的价格。然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。 

 给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。另有一个整数数组 needs 表示购物清单，其中 needs[i]
 是需要购买第 i 件物品的数量。 

 还有一个数组 special 表示大礼包，special[i] 的长度为 n + 1 ，其中 special[i][j] 表示第 i 个大礼包中内含第 j 件
物品的数量，且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格。 

 返回 确切 满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。任意大礼包可无限次购
买。 

 

 示例 1： 

 
输入：price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
输出：14
解释：有 A 和 B 两种物品，价格分别为 ¥2 和 ¥5 。 
大礼包 1 ，你可以以 ¥5 的价格购买 3A 和 0B 。 
大礼包 2 ，你可以以 ¥10 的价格购买 1A 和 2B 。 
需要购买 3 个 A 和 2 个 B ， 所以付 ¥10 购买 1A 和 2B（大礼包 2），以及 ¥4 购买 2A 。 

 示例 2： 

 
输入：price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
输出：11
解释：A ，B ，C 的价格分别为 ¥2 ，¥3 ，¥4 。
可以用 ¥4 购买 1A 和 1B ，也可以用 ¥9 购买 2A ，2B 和 1C 。 
需要买 1A ，2B 和 1C ，所以付 ¥4 买 1A 和 1B（大礼包 1），以及 ¥3 购买 1B ， ¥4 购买 1C 。 
不可以购买超出待购清单的物品，尽管购买大礼包 2 更加便宜。 

 

 提示： 

 
 n == price.length == needs.length 
 1 <= n <= 6 
 0 <= price[i], needs[i] <= 10 
 1 <= special.length <= 100 
 special[i].length == n + 1 
 0 <= special[i][j] <= 50 
 生成的输入对于 0 <= j <= n - 1 至少有一个 special[i][j] 非零。 
 

 👍 427 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-11-03 17:24:59
 */
public class ShoppingOffers{
    public static void main(String[] args) {
        Solution solution = new ShoppingOffers().new Solution();
        System.out.println(solution.shoppingOffers(Arrays.asList(2,6,7,10,2,4),
                Arrays.asList(Arrays.asList(0,3,1,4,4,3,12),Arrays.asList(3,3,3,3,4,5,25),Arrays.asList(4,6,0,2,1,1,5),Arrays.asList(1,3,0,4,4,2,6),Arrays.asList(0,3,1,0,5,0,2),Arrays.asList(0,3,1,3,4,4,24),Arrays.asList(6,0,1,3,4,2,19),Arrays.asList(5,1,4,5,3,4,22))
                , Arrays.asList(0,4,5,0,0,6)));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<List<Integer>, Integer> memo = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        List<List<Integer>> filterSpecial = new ArrayList<List<Integer>>();
        for (List<Integer> sp : special) {
            int totalCount = 0;
            int totalPrice = 0;
            for (int i = 0; i < n; i++) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > sp.get(n)) {
                filterSpecial.add(sp);
            }
        }
        return dfs(price, special, needs, filterSpecial, n);
    }
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> curNeeds, List<List<Integer>> filterSpecial, int n) {
        if (!memo.containsKey(curNeeds)) {
            int minPrice = 0;
            for (int i = 0; i < n; i++) {
                minPrice += curNeeds.get(i) * price.get(i);
            }
            for (List<Integer> sp : filterSpecial) {
                int currPrice = sp.get(n);
                List<Integer> newNeeds = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (sp.get(i) > curNeeds.get(i)) {
                        break;
                    }
                    newNeeds.add(curNeeds.get(i) - sp.get(i));
                }
                if (newNeeds.size() == n) {
                    minPrice = Math.min(minPrice, dfs(price, special, newNeeds,filterSpecial, n) + currPrice);
                }
            }
            memo.put(curNeeds, minPrice);
        }
        return memo.get(curNeeds);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}