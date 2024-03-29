//珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。 
//
// 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。 
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 
//
// 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：piles = [3,6,7,11], h = 8
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：piles = [30,11,23,4,20], h = 5
//输出：30
// 
//
// 示例 3： 
//
// 
//输入：piles = [30,11,23,4,20], h = 6
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 375 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-06-07 22:00:06
 */
public class KokoEatingBananas{
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
        System.out.println(solution.minEatingSpeed(new int[]{34392671,891616382,813261297
        },712127987));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] arr;
    public int minEatingSpeed(int[] piles, int h) {
        arr = piles;
        int max = 0;
        long sum = 0;
        for (int i = 0 ; i < piles.length; i++) {
            sum += piles[i];
            max = Math.max(max, piles[i]);
        }
        sum += h - 1;
        int min = (int)(sum / h);
        int result = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (check(mid, h)) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }
    public boolean check(int mid, int target) {
        int currentResult = 0;
        for (int i = 0; i < arr.length; i++) {
            currentResult += (arr[i] - 1 + mid) / mid;
            if (currentResult > target) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}