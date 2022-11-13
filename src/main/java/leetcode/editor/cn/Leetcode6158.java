package leetcode.editor.cn;

import java.lang.reflect.GenericDeclaration;

public class Leetcode6158 {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length() + 2;
        StringBuilder stringBuilder = new StringBuilder(s);
        int[] sub = new int[n];
        for (int[] arr : shifts) {
            int startIndex = arr[0] + 1;
            int endIndex = arr[1] + 1;
            int result = arr[2] == 0 ? -1 : 1;
            sub[startIndex] += result;
            sub[endIndex + 1] -= result;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += sub[i + 1];
            stringBuilder.setCharAt(i, get(stringBuilder.charAt(i), sum));
        }
        return stringBuilder.toString();
    }
    public char get(char s, int length) {
        int base = s - 'a';
        int temp = Math.abs(length);
        if (length == 0) {
            return s;
        }
        int result = (base + (int)(length / temp) * (temp % 26) + 26) % 26;
        return (char)('a' + result);
    }
}
