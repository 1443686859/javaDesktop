package leetcode.editor.cn;

public class Leetcode6074 {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i  < s.length(); i++) {
            if (letter == s.charAt(i)) {
                count++;
            }
        }
        return count  * 100 / s.length();
    }
}
