package leetcode.editor.cn;

public class Leetcode6359 {
    public int minMaxDifference(int num) {
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            result.insert(0, num % 10);
            num /= 10;
        }
        int max = 0;
        int min = 0;
        char current = result.charAt(0);
        char maxCurrent = '0';
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '9') {
                maxCurrent = result.charAt(i);
                break;
            }
        }
        for (int i = 0; i < result.length(); i++) {
            if (current == result.charAt(i)) {
                min = min * 10 + 0;
            } else {
                min = min * 10 + (result.charAt(i) - '0');
            }
            if (maxCurrent == result.charAt(i)) {
                max = max * 10 + 9;
            } else {
                max = max * 10 + (result.charAt(i) - '0');
            }
        }
        return max - min;
    }
}
