//给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左
//下角点，(xi, yi) 是第 i 个矩形的右上角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等
//概率被返回。 
//
// 在给定的矩形覆盖的空间内的任何整数点都有可能被返回。 
//
// 请注意 ，整数点是具有整数坐标的点。 
//
// 实现 Solution 类: 
//
// 
// Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。 
// int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。 
// 
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
//输入: 
//["Solution", "pick", "pick", "pick", "pick", "pick"]
//[[[[-2, -2, 1, 1], [2, 2, 4, 6]]], [], [], [], [], []]
//输出: 
//[null, [1, -2], [1, -1], [-1, -2], [-2, -2], [0, 0]]
//
//解释：
//Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
//solution.pick(); // 返回 [1, -2]
//solution.pick(); // 返回 [1, -1]
//solution.pick(); // 返回 [-1, -2]
//solution.pick(); // 返回 [-2, -2]
//solution.pick(); // 返回 [0, 0] 
//
// 
//
// 提示： 
//
// 
// 1 <= rects.length <= 100 
// rects[i].length == 4 
// -10⁹ <= ai < xi <= 10⁹ 
// -10⁹ <= bi < yi <= 10⁹ 
// xi - ai <= 2000 
// yi - bi <= 2000 
// 所有的矩形不重叠。 
// pick 最多被调用 10⁴ 次。 
// 
// Related Topics 水塘抽样 数学 二分查找 有序集合 前缀和 随机化 👍 120 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Random;

/**
 * @author  YourName
 * @date 2022-06-09 22:34:26
 */
public class RandomPointInNonOverlappingRectangles{
    public static void main(String[] args) {
//        Solution solution = new RandomPointInNonOverlappingRectangles().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] arr;
        Random random;
        int[][] rects;
    public Solution(int[][] rects) {
        this.rects = rects;
        random = new Random();
        arr = new int[rects.length];
        arr[0] = (rects[0][3] - rects[0][1] + 1) * (rects[0][2] - rects[0][0] + 1);
        for (int i = 1; i < rects.length; i++) {
            arr[i] = arr[i - 1] + (rects[i][3] - rects[i][1] + 1) * (rects[i][2] - rects[i][0] + 1);
        }
    }
    
    public int[] pick() {
        int sum = arr[arr.length - 1];
        int target = random.nextInt(sum) + 1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
               right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int result = right + 1;
        int current = arr[result] - target;
        return new int[]{rects[result][0] +  current / (rects[result][3] - rects[result][1] + 1), rects[result][1] + current % (rects[result][3] - rects[result][1] + 1)};

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)

}