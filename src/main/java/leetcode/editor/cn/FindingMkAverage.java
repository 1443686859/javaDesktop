//给你两个整数 m 和 k ，以及数据流形式的若干整数。你需要实现一个数据结构，计算这个数据流的 MK 平均值 。 
//
// MK 平均值 按照如下步骤计算： 
//
// 
// 如果数据流中的整数少于 m 个，MK 平均值 为 -1 ，否则将数据流中最后 m 个元素拷贝到一个独立的容器中。 
// 从这个容器中删除最小的 k 个数和最大的 k 个数。 
// 计算剩余元素的平均值，并 向下取整到最近的整数 。 
// 
//
// 请你实现 MKAverage 类： 
//
// 
// MKAverage(int m, int k) 用一个空的数据流和两个整数 m 和 k 初始化 MKAverage 对象。 
// void addElement(int num) 往数据流中插入一个新的元素 num 。 
// int calculateMKAverage() 对当前的数据流计算并返回 MK 平均数 ，结果需 向下取整到最近的整数 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["MKAverage", "addElement", "addElement", "calculateMKAverage", "addElement", 
//"calculateMKAverage", "addElement", "addElement", "addElement", 
//"calculateMKAverage"]
//[[3, 1], [3], [1], [], [10], [], [5], [5], [5], []]
//输出：
//[null, null, null, -1, null, 3, null, null, null, 5]
//
//解释：
//MKAverage obj = new MKAverage(3, 1); 
//obj.addElement(3);        // 当前元素为 [3]
//obj.addElement(1);        // 当前元素为 [3,1]
//obj.calculateMKAverage(); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
//obj.addElement(10);       // 当前元素为 [3,1,10]
//obj.calculateMKAverage(); // 最后 3 个元素为 [3,1,10]
//                          // 删除最小以及最大的 1 个元素后，容器为 [3]
//                          // [3] 的平均值等于 3/1 = 3 ，故返回 3
//obj.addElement(5);        // 当前元素为 [3,1,10,5]
//obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
//obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
//obj.calculateMKAverage(); // 最后 3 个元素为 [5,5,5]
//                          // 删除最小以及最大的 1 个元素后，容器为 [5]
//                          // [5] 的平均值等于 5/1 = 5 ，故返回 5
// 
//
// 
//
// 提示： 
//
// 
// 3 <= m <= 10⁵ 
// 1 <= k*2 < m 
// 1 <= num <= 10⁵ 
// addElement 与 calculateMKAverage 总操作次数不超过 10⁵ 次。 
// 
//
// Related Topics 设计 队列 数据流 有序集合 堆（优先队列） 👍 89 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author  YourName
 * @date 2023-01-18 22:48:45
 */
public class FindingMkAverage{
    public static void main(String[] args) {
        MKAverage obj = new MKAverage(3, 1);
        obj.addElement(3);        // 当前元素为 [3]
        obj.addElement(1);        // 当前元素为 [3,1]
        obj.calculateMKAverage(); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
        obj.addElement(10);       // 当前元素为 [3,1,10]
        obj.calculateMKAverage(); // 最后 3 个元素为 [3,1,10]
        // 删除最小以及最大的 1 个元素后，容器为 [3]
        // [3] 的平均值等于 3/1 = 3 ，故返回 3
        obj.addElement(5);        // 当前元素为 [3,1,10,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
        obj.calculateMKAverage(); // 最后 3 个元素为 [5,5,5]
        // 删除最小以及最大的 1 个元素后，容器为 [5]
        // [5] 的平均值等于 5/1 = 5 ，故返回 5
   }
//leetcode submit region begin(Prohibit modification and deletion)
static class MKAverage {
    TreeMap<Integer, Integer> maxMap = new TreeMap<>();
    TreeMap<Integer, Integer> midMap = new TreeMap<>();
    TreeMap<Integer, Integer> minMap = new TreeMap<>();
    int size1;
    int size3;
    long sum;
    int m;
    int k;
    int[] arr;
    int index;
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        arr = new int[m];
        index = 0;
    }
    
    public void addElement(int num) {
        int oldVal  = arr[index % m];
        arr[index % m] = num;
        index++;
        if (minMap.isEmpty() || num <= minMap.lastKey()) {
            minMap.put(num, minMap.getOrDefault(num, 0) + 1);
            size1++;
        } else if (maxMap.isEmpty() || num >= maxMap.firstKey()) {
            maxMap.put(num, maxMap.getOrDefault(num, 0) + 1);
            size3++;
        } else {
            midMap.put(num, midMap.getOrDefault(num, 0) + 1) ;
            sum += num;
        }
        if (index > m) {
            if (minMap.containsKey(oldVal)) {
                minMap.put(oldVal, minMap.get(oldVal) - 1);
                if (minMap.get(oldVal) == 0) {
                    minMap.remove(oldVal);
                }
                size1--;
            } else if (maxMap.containsKey(oldVal)) {
                maxMap.put(oldVal, maxMap.get(oldVal) - 1);
                if (maxMap.get(oldVal) == 0) {
                    maxMap.remove(oldVal);
                }
                size3--;
            } else {
                midMap.put(oldVal, midMap.get(oldVal) - 1);
                if (midMap.get(oldVal) == 0) {
                    midMap.remove(oldVal);
                }
                sum -= oldVal;
            }
        }
        // 总个数为m时
        while (size1 > k) {
            int maxKey = minMap.lastKey();
            midMap.put(maxKey, midMap.getOrDefault(maxKey, 0) + 1);
            sum += maxKey;
            minMap.put(maxKey, minMap.get(maxKey) - 1);
            if (minMap.get(maxKey) == 0) {
                minMap.remove(maxKey);
            }
            size1--;
        }
        while (size3 > k) {
            int minKey = maxMap.firstKey();
            midMap.put(minKey, midMap.getOrDefault(minKey, 0) + 1);
            sum += minKey;
            maxMap.put(minKey, maxMap.get(minKey) - 1);
            if (maxMap.get(minKey) == 0) {
                maxMap.remove(minKey);
            }
            size3--;
        }
        // 处理中间值
        while (size1 < k && !midMap.isEmpty()) {
            int minKey = midMap.firstKey();
            minMap.put(minKey, minMap.getOrDefault(minKey, 0) + 1);
            sum -= minKey;
            midMap.put(minKey, midMap.get(minKey) - 1);
            if (midMap.get(minKey) == 0) {
                midMap.remove(minKey);
            }
            size1++;
        }
        while (size3 < k && !midMap.isEmpty()) {
            int maxKey = midMap.lastKey();
            maxMap.put(maxKey, maxMap.getOrDefault(maxKey, 0) + 1);
            sum -= maxKey;
            midMap.put(maxKey, midMap.get(maxKey) - 1);
            if (midMap.get(maxKey) == 0) {
                midMap.remove(maxKey);
            }
            size3++;
        }
    }
    
    public int calculateMKAverage() {
        if (index < m) {
            return -1;
        }
        return (int)(sum / (m - 2 * k));
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
//leetcode submit region end(Prohibit modification and deletion)

}