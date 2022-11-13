package leetcode.editor.cn;

public class Leetcode6181 {
    public int longestContinuousSubstring(String s) {
        int result = 1;
        int tempResult = 1;
        for (int i = 1; i < s.length(); i++) {
            char preChar = s.charAt(i - 1);
            char currentChar = s.charAt(i);
            if (currentChar - preChar == 1) {
                tempResult++;
            } else {
                result = Math.max(result, tempResult);
                tempResult = 1;
            }
        }
        result = Math.max(result, tempResult);
        return result;
    }
}
