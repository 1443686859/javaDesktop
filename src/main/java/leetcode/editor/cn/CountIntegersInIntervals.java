//给你区间的 空 集，请你设计并实现满足要求的数据结构： 
//
// 
// 新增：添加一个区间到这个区间集合中。 
// 统计：计算出现在 至少一个 区间中的整数个数。 
// 
//
// 实现 CountIntervals 类： 
//
// 
// CountIntervals() 使用区间的空集初始化对象 
// void add(int left, int right) 添加区间 [left, right] 到区间集合之中。 
// int count() 返回出现在 至少一个 区间中的整数个数。 
// 
//
// 注意：区间 [left, right] 表示满足 left <= x <= right 的所有整数 x 。 
//
// 
//
// 示例 1： 
//
// 
//输入
//["CountIntervals", "add", "add", "count", "add", "count"]
//[[], [2, 3], [7, 10], [], [5, 8], []]
//输出
//[null, null, null, 6, null, 8]
//
//解释
//CountIntervals countIntervals = new CountIntervals(); // 用一个区间空集初始化对象
//countIntervals.add(2, 3);  // 将 [2, 3] 添加到区间集合中
//countIntervals.add(7, 10); // 将 [7, 10] 添加到区间集合中
//countIntervals.count();    // 返回 6
//                           // 整数 2 和 3 出现在区间 [2, 3] 中
//                           // 整数 7、8、9、10 出现在区间 [7, 10] 中
//countIntervals.add(5, 8);  // 将 [5, 8] 添加到区间集合中
//countIntervals.count();    // 返回 8
//                           // 整数 2 和 3 出现在区间 [2, 3] 中
//                           // 整数 5 和 6 出现在区间 [5, 8] 中
//                           // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
//                           // 整数 9 和 10 出现在区间 [7, 10] 中 
//
// 
//
// 提示： 
//
// 
// 1 <= left <= right <= 10⁹ 
// 最多调用 add 和 count 方法 总计 10⁵ 次 
// 调用 count 方法至少一次 
// 
//
// Related Topics 设计 线段树 有序集合 👍 92 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-12-16 23:23:27
 */
public class CountIntegersInIntervals{
    public static void main(String[] args) {
//       CountIntervals countIntervals =new CountIntervals();
//       countIntervals.add(457,717);
//       countIntervals.add(918,927);
//
//        System.out.println(countIntervals.count());
//
//        countIntervals.add(885,905);
//        countIntervals.add(12,32);
//        countIntervals.add(7,15);
//        countIntervals.add(49,49);
//        System.out.println(countIntervals.count());
   }
//leetcode submit region begin(Prohibit modification and deletion)
class CountIntervals {

        List<int[]> list;
        int count;

    public CountIntervals() {
        count = 0;
        list = new ArrayList<>();
    }
    
    public void add(int left, int right) {
        int pre = 0;
        int after = list.size() - 1;
        while (pre <= after) {
            int mid = (pre + after) / 2;
            if (list.get(mid)[1] < left) {
                pre = mid + 1;
            } else {
                after = mid - 1;
            }
        }
        int index = after + 1;
        if (index == list.size()) {
            list.add(new int[]{left, right});
            count += right - left + 1;
            return ;
        }
        if (list.get(index)[0] > right) {
            List<int[]> preL = list.subList(0, index);
            List<int[]> temp = list.subList(index, list.size());
            List<int[]> result = new ArrayList<>();
            result.addAll(preL);
            count += right - left + 1;
            result.add(new int[]{left, right});
            result.addAll(temp);
            list = result;
        } else {
            count -= list.get(index)[1] - list.get(index)[0] + 1;
            list.get(index)[0] = Math.min(list.get(index)[0], left);
            list.get(index)[1] = Math.max(list.get(index)[1], right);
            count += list.get(index)[1] - list.get(index)[0] + 1;
            while (index + 1 < list.size() && list.get(index)[1] >= list.get(index + 1)[0]) {
                int[] next = list.get(index + 1);
                count -= list.get(index)[1] - list.get(index)[0] + 1;
                count -= list.get(index + 1)[1] - list.get(index + 1)[0] + 1;
                list.get(index)[0] = Math.min(list.get(index)[0], next[0]);
                list.get(index)[1] = Math.max(list.get(index)[1], next[1]);
                count += list.get(index)[1] - list.get(index)[0] + 1;
                list.remove(index + 1);
            }
            while (index - 1 >= 0 && list.get(index)[0] <= list.get(index - 1)[1]) {
                int[] next = list.get(index + 1);
                count -= list.get(index)[1] - list.get(index)[0] + 1;
                count -= list.get(index - 1)[1] - list.get(index - 1)[0] + 1;
                list.get(index)[0] = Math.min(list.get(index)[0], next[0]);
                list.get(index)[1] = Math.max(list.get(index)[1], next[1]);
                count += list.get(index)[1] - list.get(index)[0] + 1;
                list.remove(index - 1);
                index--;
            }
        }

    }
    
    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
//leetcode submit region end(Prohibit modification and deletion)

}