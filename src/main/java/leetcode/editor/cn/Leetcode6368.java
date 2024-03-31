package leetcode.editor.cn;

public class Leetcode6368 {
    public static void main(String[] args) {
        Leetcode6368 leetcode6368 = new Leetcode6368();
        System.out.println(leetcode6368.divisibilityArray("4868438856666666",6));
    }
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        long[] result = new long[n];
        int[] ans = new int[n];
        long pre = 0;
        for (int i = 0; i < n; i++) {
            result[i] = ((pre * 10) % m + (word.charAt(i) - '0') % m) % m;
            if (result[i] == 0) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
            pre = result[i];
        }
        return ans;
    }
}
