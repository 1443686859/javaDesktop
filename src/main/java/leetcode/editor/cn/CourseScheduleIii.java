//这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [durationi, 
//lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。 
//
// 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。 
//
// 返回你最多可以修读的课程数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
//输出：3
//解释：
//这里一共有 4 门课程，但是你最多可以修 3 门：
//首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
//第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
//第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
//第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。 
//
// 示例 2： 
//
// 
//输入：courses = [[1,2]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：courses = [[3,2],[4,3]]
//输出：0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= courses.length <= 10⁴ 
// 1 <= durationi, lastDayi <= 10⁴ 
// 
//
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 540 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author  YourName
 * @date 2023-09-11 21:04:01
 */
public class CourseScheduleIii{
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIii().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> {

               return a[1] - b[1];

        });
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> {
            return b - a;
        });
        int pre = 0;
        for (int i = 0; i < courses.length; i++) {
            if (pre + courses[i][0] <= courses[i][1]) {
                priorityQueue.add(courses[i][0]);
                pre += courses[i][0];
            } else {
                if (!priorityQueue.isEmpty() && priorityQueue.peek() > courses[i][0]) {
                    pre -=priorityQueue.poll();
                    pre += courses[i][0];
                    priorityQueue.add(courses[i][0]);
                }
            }
        }
        return priorityQueue.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}