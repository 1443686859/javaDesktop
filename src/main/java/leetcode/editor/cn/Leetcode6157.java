package leetcode.editor.cn;

public class Leetcode6157 {
    public int secondsToRemoveOccurrences(String s) {
        int zeroCount = 0;
        boolean isRight = false;
        int add = 0;
        boolean isOne = false;
        int endIndex = s.length() - 1;
        while (endIndex >= 0 && s.charAt(endIndex) != '1') {
            endIndex --;
        }
        int startIndex = 0;
        while (startIndex < s.length() && s.charAt(startIndex) != '0') {
            startIndex++;
        }
        for (int i = startIndex; i <= endIndex; i++) {
            if (isOne && s.charAt(i) == '1') {
                add++;
            }
            if (s.charAt(i) == '1') {
                if (zeroCount != 0) {
                    isRight = true;
                }
                isOne = true;
            } else {
                zeroCount++;
                isOne = false;
            }
        }

        if (isRight) {
            return zeroCount + add;
        }
        return 0;
    }
}
