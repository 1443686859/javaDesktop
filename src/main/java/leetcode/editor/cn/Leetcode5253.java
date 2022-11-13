package leetcode.editor.cn;

public class Leetcode5253 {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int actualLength = intLength / 2 + (intLength % 2);
        int maxIndex = 9 * (int)Math.pow(10, actualLength - 1);
        long[] result = new long[queries.length];
        long base = (long)Math.pow(10, actualLength- 1);
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > maxIndex) {
                result[i] = - 1;
                continue;
            } else {
                result[i] = base + queries[i] - 1;
            }
            long temp = intLength % 2 == 1 ? result[i] / 10 : result[i];
            while (temp != 0) {
                result[i] = result[i] * 10 + temp % 10;
                temp /= 10;
            }
        }
        return result;

    }
}
