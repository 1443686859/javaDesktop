package leetcode.editor.cn;

public class Leetcode6455 {
    public static void main(String[] args) {
        Leetcode6455 leetcode6455 = new Leetcode6455();
        System.out.println(leetcode6455.minimumCost("0011"));
    }
    public long minimumCost(String s) {
        int n = s.length();
        char[] current = s.toCharArray();

        long oneResult = 0;
        long zeroResult = 0;
        int startIndex = 0;
        int endIndex = n - 1;
        while (startIndex < n) {
            if (current[startIndex + 1] == current[startIndex]) {
                startIndex++;
            } else {
                break;
            }
        }
        while (endIndex > 0) {
            if (current[endIndex - 1] == current[endIndex]) {
                endIndex --;
            } else {
                break;
            }
        }
        long[] zCount = new long[n];
        long[] oCount = new long[n];
        if (startIndex > 0) {
            if (current[startIndex] == '0') {
                oCount[startIndex] = startIndex - 1;
            }
        }
        if (endIndex <= n - 1) {
            if (current[endIndex] == '1') {
                zCount[endIndex] = n - 1 - endIndex;
            }
        }

        for (int i = startIndex; i <= endIndex; i++) {
            if (current[i] == '1') {
                zCount[i] = Math.min(2 * (i - startIndex) + 1, 2 * (n - i) - 1);
                zeroResult += zCount[i];
            }
            if (current[i] == '0') {
                oCount[i] = Math.min(2 * (i - startIndex) + 1, 2 * (n - i) - 1);
                oneResult += oCount[i];
            }
        }
        return Math.min(oneResult, zeroResult);
    }
}
