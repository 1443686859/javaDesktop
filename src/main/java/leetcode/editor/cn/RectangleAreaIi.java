//我们给出了一个（轴对齐的）二维矩形列表 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是
//矩形 i 左下角的坐标，
// (xi1, yi1) 是该矩形 左下角 的坐标，
// (xi2, yi2) 是该矩形 右上角 的坐标。 
//
// 计算平面中所有 rectangles 所覆盖的 总面积 。任何被两个或多个矩形覆盖的区域应只计算 一次 。 
//
// 返回 总面积 。因为答案可能太大，返回
// 10⁹ + 7 的 模 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
//输出：6
//解释：如图所示，三个矩形覆盖了总面积为6的区域。
//从(1,1)到(2,2)，绿色矩形和红色矩形重叠。
//从(1,0)到(2,3)，三个矩形都重叠。
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[0,0,1000000000,1000000000]]
//输出：49
//解释：答案是 10¹⁸ 对 (10⁹ + 7) 取模的结果， 即 49 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 200 
// rectanges[i].length = 4
// 
// 0 <= xi1, yi1, xi2, yi2 <= 10⁹ 
// 矩形叠加覆盖后的总面积不会超越 2^63 - 1 ，这意味着可以用一个 64 位有符号整数来保存面积结果。 
// 
//
// Related Topics 线段树 数组 有序集合 扫描线 👍 212 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-09-16 22:09:53
 */
public class RectangleAreaIi{
    public static void main(String[] args) {
        Solution solution = new RectangleAreaIi().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rectangleArea(int[][] rectangles) {
        int MOD =(int)1e9 + 7;
        List<Integer> currentList = new ArrayList<>();
        long result = 0;
        for (int[] rectangle : rectangles) {
            currentList.add(rectangle[0]);
            currentList.add(rectangle[2]);
        }
        Collections.sort(currentList);
        for (int i = 1; i < currentList.size(); i++) {
            int pre = currentList.get(i - 1);
            int current = currentList.get(i);
            int len = current - pre;
            if (len == 0) {
                continue;
            }
            List<int[]> hegihtList = new ArrayList<>();
            for (int[] rectangle : rectangles) {
                if (rectangle[0] <= pre && current <= rectangle[2]) {
                    hegihtList.add(new int[]{rectangle[1], rectangle[3]});
                }
            }
            Collections.sort(hegihtList, (newOne, oldOne) -> {
                return newOne[0] != oldOne[0] ? newOne[0] - oldOne[0] : newOne[1] - oldOne[1];
            });
            long low = -1;
            long high = -1;
            long currentHeight = 0;
            for (int[] height : hegihtList) {
                if (height[0] > high) {
                    currentHeight += high - low;
                    low = height[0];
                    high = height[1];
                } else if (height[1] > high) {
                    high = height[1];
                }
            }
            currentHeight += high - low;
            result += currentHeight * len;
            result %= MOD;
        }
        return (int)result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}