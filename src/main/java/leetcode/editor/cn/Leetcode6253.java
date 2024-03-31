package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6253 {
    public static void main(String[] args) {
        Leetcode6253 leetcode6253 = new Leetcode6253();
        System.out.println(leetcode6253.isCircularSentence("leetcode"));
    }
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        char last;
        char first;
        if (s.length == 1){
            return s[0].charAt(0) == s[0].charAt(s[0].length() - 1);
        }
        for (int i = 1; i < s.length; i++) {
           if (i != s.length - 1) {
                last = s[i - 1].charAt(s[i - 1].length() - 1);
                if (last != s[i].charAt(0)) {
                    return false;
                }
            } else {
                first = s[0].charAt(0);
                last = s[i - 1].charAt(s[i - 1].length() - 1);
                if (first != s[i].charAt(s[i].length() - 1) || last != s[i].charAt(0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
