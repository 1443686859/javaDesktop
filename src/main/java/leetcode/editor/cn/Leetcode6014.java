package leetcode.editor.cn;

import java.util.SortedMap;
import java.util.TreeMap;

public class Leetcode6014 {
    public static void main(String[] args) {
        Leetcode6014 leetcode6014 = new Leetcode6014();
        System.out.println(leetcode6014.repeatLimitedString("",
                100000));
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        long[] chars = new long[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        int count = 0;
        int max = s.length();
        int index  = -1;
        while (count < max) {
            boolean cycle = true;
            for (int i = 25; i >= 0; i--) {
                int currentCount = 0;
                if (chars[i] != 0 && !check(result, repeatLimit, (char)(i + 'a'))) {
                    result.append((char)(i + 'a'));
                    chars[i]--;
                    cycle =false;
                    break;
                }
            }
            count++;
            if (cycle) {
                break;
            }
        }
        return result.toString();
    }
    public boolean check(StringBuilder s, int length, char current) {
        int start = s.length() - length;
        if (start < 0) {
            return false;
        }
        for (int i = start; i < s.length(); i++) {
            if (current != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
