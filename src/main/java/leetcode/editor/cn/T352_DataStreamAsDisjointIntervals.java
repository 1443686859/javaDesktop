//给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。 
//
// 实现 SummaryRanges 类： 
//
// 
// 
// 
// SummaryRanges() 使用一个空数据流初始化对象。 
// void addNum(int val) 向数据流中加入整数 val 。 
// int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", 
//"addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
//[[], [1], [], [3], [], [7], [], [2], [], [6], []]
//输出：
//[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]],
// null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
//
//解释：
//SummaryRanges summaryRanges = new SummaryRanges();
//summaryRanges.addNum(1);      // arr = [1]
//summaryRanges.getIntervals(); // 返回 [[1, 1]]
//summaryRanges.addNum(3);      // arr = [1, 3]
//summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
//summaryRanges.addNum(7);      // arr = [1, 3, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
//summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
//summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= val <= 10⁴ 
// 最多调用 addNum 和 getIntervals 方法 3 * 10⁴ 次 
// 
// 
// 
//
// 
//
// 进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办? 
// Related Topics 设计 二分查找 有序集合 👍 138 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Java：将数据流变为多个不相交区间
public class T352_DataStreamAsDisjointIntervals{
    public static void main(String[] args) {
//        Solution solution = new T352_DataStreamAsDisjointIntervals().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class SummaryRanges {
        TreeMap<Integer, Integer> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        Map.Entry<Integer, Integer> right = map.ceilingEntry(val + 1);
        Map.Entry<Integer, Integer> left = map.floorEntry(val);
        if (left != null && left.getKey() <= val && left.getValue() >= val) {
            return;
        } else {
            boolean leftSide = left != null && left.getValue() + 1 == val;
            boolean rightSide = right != null && right.getKey() - 1 == val;
            if (leftSide && rightSide) {
                // 合并两个区间
//                int newLeft = left.getKey();
//                int newRight = right.getKey();
                map.remove(left.getKey());
                map.remove(right.getKey());
                map.put(left.getKey(), right.getValue());
            } else if (leftSide) {
                map.put(left.getKey(), val);
            } else if (rightSide) {
                map.remove(right.getKey());
                map.put(val, right.getValue());
            } else {
                map.put(val, val);
            }
        }
    }
    
    public int[][] getIntervals() {
        int size = map.size();
        int[][] ans = new int[size][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int left = entry.getKey(), right = entry.getValue();
            ans[index][0] = left;
            ans[index][1] = right;
            ++index;
        }
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
//leetcode submit region end(Prohibit modification and deletion)

}