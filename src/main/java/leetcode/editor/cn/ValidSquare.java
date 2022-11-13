//给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。 
//
// 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。 
//
// 一个 有效的正方形 有四条等边和四个等角(90度角)。 
//
// 
//
// 示例 1: 
//
// 
//输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//输出: True
// 
//
// 示例 2: 
//
// 
//输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//输出：false
// 
//
// 示例 3: 
//
// 
//输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//输出：true
// 
//
// 
//
// 提示: 
//
// 
// p1.length == p2.length == p3.length == p4.length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 
//
// Related Topics 几何 数学 👍 152 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-07-29 21:59:58
 */
public class ValidSquare{
    public static void main(String[] args) {
        Solution solution = new ValidSquare().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int finalLenght = -1;
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return check(p1, p2, p3) && check(p1, p2, p4) && check(p1, p3, p4) && check(p2, p3, p4);
    }
    public int getDistance(int[] p1, int[] p2) {
        return (int)Math.pow(p2[1] - p1[1], 2) + (int)Math.pow(p2[0] - p1[0], 2);
    }
    public boolean check(int[] p1, int[] p2, int[] p3) {
        int l1 = getDistance(p1, p2);
        int l2 = getDistance(p1, p3);
        int l3 = getDistance(p2, p3);
        boolean currentResult = (l1 == l2 && l1 + l2 == l3) || (l2 == l3 && l2+ l3 == l1) || (l1 == l3 && l1 + l3 == l2);
        if (!currentResult) {
            return false;
        }
        if (finalLenght == -1) {
            finalLenght = Math.min(l1, l2);
        } else if (finalLenght == 0 || finalLenght != Math.min(l1, l2)) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}