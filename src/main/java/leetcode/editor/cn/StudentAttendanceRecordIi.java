package leetcode.editor.cn;

//可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
// 
// 'A'：Absent，缺勤 
// 'L'：Late，迟到 
// 'P'：Present，到场 
// 
//
// 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励： 
//
// 
// 按 总出勤 计，学生缺勤（'A'）严格 少于两天。 
// 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。 
// 
//
// 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 
//取余 的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：8
//解释：
//有 8 种长度为 2 的记录将被视为可奖励：
//"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL" 
//只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：n = 10101
//输出：183236316
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 105 
// 
// Related Topics 动态规划 
// 👍 206 👎 0

public class StudentAttendanceRecordIi{
    public static void main(String[] args) {
        Solution solution = new StudentAttendanceRecordIi().new Solution();
        System.out.println(solution.checkRecord(10101));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][] dp = new int[2][3];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int[][] dpNew = new int[2][3];
            // 当前状态为出席状态
            for (int k = 0; k < 2; k++) {
                for (int j = 0; j < 3; j++) {
                    dpNew[k][0] = (dpNew[k][0] + dp[k][j]) % MOD;
                }
            }
            // 当前状态为缺席
            for (int j = 0; j < 3; j++) {
                dpNew[1][0] = (dpNew[1][0] + dp[0][j]) % MOD;
            }
            // 当前状态为迟到
            for (int k = 0; k < 2; k++) {
                for (int j = 1; j < 3; j++) {
                    dpNew[k][j] = (dpNew[k][j] + dp[k][j - 1]) % MOD;
                }
            }
            dp = dpNew;
        }
        int sum = 0;
        for (int k = 0; k < 2; k++) {
            for (int j = 0; j < 3; j++) {
                sum = (sum + dp[k][j]) % MOD;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}