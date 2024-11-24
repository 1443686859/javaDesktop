//给你一个整数 n 表示某所大学里课程的数目，编号为 1 到 n ，数组 relations 中， relations[i] = [xi, yi] 表示一个先
//修课的关系，也就是课程 xi 必须在课程 yi 之前上。同时你还有一个整数 k 。 
//
// 在一个学期中，你 最多 可以同时上 k 门课，前提是这些课的先修课在之前的学期里已经上过了。 
//
// 请你返回上完所有课最少需要多少个学期。题目保证一定存在一种上完所有课的方式。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 4, relations = [[2,1],[3,1],[1,4]], k = 2
//输出：3 
//解释：上图展示了题目输入的图。在第一个学期中，我们可以上课程 2 和课程 3 。然后第二个学期上课程 1 ，第三个学期上课程 4 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 5, relations = [[2,1],[3,1],[4,1],[1,5]], k = 2
//输出：4 
//解释：上图展示了题目输入的图。一个最优方案是：第一学期上课程 2 和 3，第二学期上课程 4 ，第三学期上课程 1 ，第四学期上课程 5 。
// 
//
// 示例 3： 
//
// 
//输入：n = 11, relations = [], k = 2
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 15 
// 1 <= k <= n 
// 0 <= relations.length <= n * (n-1) / 2 
// relations[i].length == 2 
// 1 <= xi, yi <= n 
// xi != yi 
// 所有先修关系都是不同的，也就是说 relations[i] != relations[j] 。 
// 题目输入的图是个有向无环图。 
// 
//
// Related Topics 位运算 图 动态规划 状态压缩 👍 178 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-06-16 21:51:06
 */
public class ParallelCoursesIi{
    public static void main(String[] args) {
        Solution solution = new ParallelCoursesIi().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int minNumberOfSemesters(int n, int[][] relations, int k) {
//        int used = 0;
//        int[] count = new int[n + 1];
//        List<Integer> list = new ArrayList<>();
//        for (int[] relation : relations) {
//            count[relation[1]]++;
//        }
//        for (int i = 1; i <= n; i++) {
//            if (count[i] == 0) {
//                list.add(i);
//            }
//        }
//
//
//    }
//
//    public int get(List<Integer> list, int k, int[] count, int used) {
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}