//给你一支股票价格的数据流。数据流中每一条记录包含一个 时间戳 和该时间点股票对应的 价格 。 
//
// 不巧的是，由于股票市场内在的波动性，股票价格记录可能不是按时间顺序到来的。某些情况下，有的记录可能是错的。如果两个有相同时间戳的记录出现在数据流中，前一条
//记录视为错误记录，后出现的记录 更正 前一条错误的记录。 
//
// 请你设计一个算法，实现： 
//
// 
// 更新 股票在某一时间戳的股票价格，如果有之前同一时间戳的价格，这一操作将 更正 之前的错误价格。 
// 找到当前记录里 最新股票价格 。最新股票价格 定义为时间戳最晚的股票价格。 
// 找到当前记录里股票的 最高价格 。 
// 找到当前记录里股票的 最低价格 。 
// 
//
// 请你实现 StockPrice 类： 
//
// 
// StockPrice() 初始化对象，当前无股票价格记录。 
// void update(int timestamp, int price) 在时间点 timestamp 更新股票价格为 price 。 
// int current() 返回股票 最新价格 。 
// int maximum() 返回股票 最高价格 。 
// int minimum() 返回股票 最低价格 。 
// 
//
// 
//
// 示例 1： 
//
// 输入：
//["StockPrice", "update", "update", "current", "maximum", "update", "maximum", 
//"update", "minimum"]
//[[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
//输出：
//[null, null, null, 5, 10, null, 5, null, 2]
//
//解释：
//StockPrice stockPrice = new StockPrice();
//stockPrice.update(1, 10); // 时间戳为 [1] ，对应的股票价格为 [10] 。
//stockPrice.update(2, 5);  // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
//stockPrice.current();     // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
//stockPrice.maximum();     // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
//stockPrice.update(1, 3);  // 之前时间戳为 1 的价格错误，价格更新为 3 。
//                          // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
//stockPrice.maximum();     // 返回 5 ，更正后最高价格为 5 。
//stockPrice.update(4, 2);  // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
//stockPrice.minimum();     // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= timestamp, price <= 10⁹ 
// update，current，maximum 和 minimum 总 调用次数不超过 10⁵ 。 
// current，maximum 和 minimum 被调用时，update 操作 至少 已经被调用过 一次 。 
// 
//
// Related Topics 设计 哈希表 数据流 有序集合 堆（优先队列） 👍 182 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author  YourName
 * @date 2023-10-08 22:52:14
 */
public class StockPriceFluctuation{
    public static void main(String[] args) {
//        Solution solution = new StockPriceFluctuation().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class StockPrice {
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        Map<Integer, Integer> timeMap;
        int index;
    public StockPrice() {
        timeMap = new HashMap<>()  ;
        countMap = new TreeMap<>();
        index = 0;
    }

    public void update(int timestamp, int price) {
        index = Math.max(index, timestamp);
        if (timeMap.containsKey(timestamp)) {
            int old = timeMap.get(timestamp);
            countMap.put(old, countMap.get(old) - 1);
            if (countMap.get(old) == 0) {
                countMap.remove(old);
            }
        }
        timeMap.put(timestamp, price);
        countMap.put(price, countMap.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return timeMap.get(index);
    }

    public int maximum() {
        return countMap.lastKey();
    }

    public int minimum() {
        return countMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
//leetcode submit region end(Prohibit modification and deletion)

}