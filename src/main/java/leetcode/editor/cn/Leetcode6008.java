package leetcode.editor.cn;

public class Leetcode6008 {
    public int prefixCount(String[] words, String pref) {
        int result = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                result++;
            }
        }
        return result;
    }
}
