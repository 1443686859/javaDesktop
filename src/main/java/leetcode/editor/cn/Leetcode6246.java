package leetcode.editor.cn;

public class Leetcode6246 {
    public int appendCharacters(String s, String t) {
        int index = 0;
        int index1 = 0;
        while (index < t.length() && index1 < s.length()) {
            if (s.charAt(index1) == t.charAt(index)) {
                index++;
            }
            index1++;
        }
        return t.length() - index;
    }
}
