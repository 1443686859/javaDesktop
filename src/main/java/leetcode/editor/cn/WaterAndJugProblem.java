//有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 
//targetCapacity 升。 
//
// 如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。 
//
// 你可以： 
//
// 
// 装满任意一个水壶 
// 清空任意一个水壶 
// 从一个水壶向另外一个水壶倒水，直到装满或者倒空 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
//输出: true
//解释：来自著名的 "Die Hard" 
//
// 示例 2: 
//
// 
//输入: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
//输出: true
// 
//
// 
//
// 提示: 
//
// 
// 1 <= jug1Capacity, jug2Capacity, targetCapacity <= 10⁶ 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数学 👍 447 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-01-28 00:20:55
 */
public class WaterAndJugProblem{
    public static void main(String[] args) {
        Solution solution = new WaterAndJugProblem().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) {
            return false;
        }
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;

    }
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public int countKeyChanges(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (Character.toLowerCase(s.charAt(i - 1)) != Character.toLowerCase(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    public long flowerGame(int n, int m) {
        int oN = n / 2 + ((n & 1) == 0 ? 0 : 1);
        int oM = (m / 2) + ((m & 1) == 0 ? 0 : 1);
        long result = 0L;
        result += 1L * oN * (m - oM) + 1L * (n - oN) * oM;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}