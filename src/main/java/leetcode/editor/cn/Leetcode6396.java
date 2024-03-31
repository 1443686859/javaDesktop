package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6396 {
    public static void main(String[] args) {
        Leetcode6396 leetcode6396 = new Leetcode6396();
        System.out.println(leetcode6396.count("1", "12", 1, 8));
    }
    private static final int MOD = (int) 1e9 + 7;
    int max;
    int min;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        max = max_sum;
        min = min_sum;
        int result =  count(num2) - count(num1) + MOD;
        int sum = 0;
        for (int i = 0; i < num1.length(); i++) {
            sum += num1.charAt(i) - '0';
        }
        if (min <= sum && sum <= max) {
            result++;
        }
        return result % MOD;
    }

    private int count(String s) {
        int n = s.length();
        int[][] memo = new int[n][Math.min(9 * n, max) + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], - 1);
        }
        return dfs(s, memo, 0, 0, true);
    }
    public int dfs(String current, int[][] memo, int index, int count, boolean isLimit) {
        if (count > max) {
            return 0;
        }
        if (index == current.length()) {
            return count >= min ? 1 : 0;
        }
        if (!isLimit && memo[index][count] != - 1) {
            return memo[index][count];
        }
        int max = isLimit ? current.charAt(index) - '0' : 9;
        int result = 0;
        for (int i = 0; i <= max; i++) {
            result = (result + dfs(current, memo, index + 1, count + i, i == max & isLimit)) % MOD;
        }
        if (!isLimit) {
            memo[index][count] = result;
        }
        return result;
    }

}
