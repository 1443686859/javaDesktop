//给你两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。不会 有单词同时是正面的和
//负面的。 
//
// 一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减 1 分。 
//
// 给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，其中 
//student_id[i] 表示这名学生的 ID ，这名学生的评语是 report[i] 。每名学生的 ID 互不相同。 
//
// 给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。 
//
// 
//
// 示例 1： 
//
// 输入：positive_feedback = ["smart","brilliant","studious"], negative_feedback = 
//["not"], report = ["this student is studious","the student is smart"], student_
//id = [1,2], k = 2
//输出：[1,2]
//解释：
//两名学生都有 1 个正面词汇，都得到 3 分，学生 1 的 ID 更小所以排名更前。
// 
//
// 示例 2： 
//
// 输入：positive_feedback = ["smart","brilliant","studious"], negative_feedback = 
//["not"], report = ["this student is not studious","the student is smart"], 
//student_id = [1,2], k = 2
//输出：[2,1]
//解释：
//- ID 为 1 的学生有 1 个正面词汇和 1 个负面词汇，所以得分为 3-1=2 分。
//- ID 为 2 的学生有 1 个正面词汇，得分为 3 分。
//学生 2 分数更高，所以返回 [2,1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= positive_feedback.length, negative_feedback.length <= 10⁴ 
// 1 <= positive_feedback[i].length, negative_feedback[j].length <= 100 
// positive_feedback[i] 和 negative_feedback[j] 都只包含小写英文字母。 
// positive_feedback 和 negative_feedback 中不会有相同单词。 
// n == report.length == student_id.length 
// 1 <= n <= 10⁴ 
// report[i] 只包含小写英文字母和空格 ' ' 。 
// report[i] 中连续单词之间有单个空格隔开。 
// 1 <= report[i].length <= 100 
// 1 <= student_id[i] <= 10⁹ 
// student_id[i] 的值 互不相同 。 
// 1 <= k <= n 
// 
//
// Related Topics 数组 哈希表 字符串 排序 堆（优先队列） 👍 56 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-10-11 23:42:48
 */
public class RewardTopKStudents{
    public static void main(String[] args) {
        Solution solution = new RewardTopKStudents().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
         int n = report.length;
         Set<String> p = new HashSet<>();
         Set<String> ne = new HashSet<>();
         for (String po : positive_feedback) {
             p.add(po);
         }
         for (String neg : negative_feedback) {
             ne.add(neg);
         }
         int[][] sort = new int[n][2];
         for (int i = 0; i < n; i++) {
             String[] current = report[i].split(" ");
             int count = 0;
             for (String c : current) {
                 if (p.contains(c)) {
                     count += 3;
                 } else if (ne.contains(c)) {
                     count -= 1;
                 }
             }
             sort[i][0] = count;
             sort[i][1] = student_id[i];
         }
         Arrays.sort(sort, (n1, o1) -> {
             if (n1[0] != o1[0]) {
                 return o1[0] - n1[0];
             } else {
                 return n1[1] - o1[1];
             }
         });
         List<Integer> result = new ArrayList<>();
         for (int i = 0; i < k; i++) {
             result.add(sort[i][1]);
         }
         return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}