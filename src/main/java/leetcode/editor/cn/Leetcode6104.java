package leetcode.editor.cn;

public class Leetcode6104 {
    public int countAsterisks(String s) {
        boolean is = false;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                is = !is;
            }
            if (c == '*' && is == false) {
                result++;
            }
        }
        return result;
    }
}
