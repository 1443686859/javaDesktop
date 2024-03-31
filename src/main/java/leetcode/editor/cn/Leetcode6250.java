package leetcode.editor.cn;

public class Leetcode6250 {
    public static void main(String[] args) {
        Leetcode6250 leetcode6250 = new Leetcode6250();
        System.out.println(leetcode6250.bestClosingTime("YYYY"));
    }
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] count = new int[n + 2];
        int cost = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                cost++;
            }
            count[i + 1] = cost;
        }
        int result = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i <= n; i++) {
            int currentResult = count[n] - count[i] + (i - count[i]);
            if (result > currentResult) {
                index = i;
                result = currentResult;
            }
        }
        return index;
    }
}
