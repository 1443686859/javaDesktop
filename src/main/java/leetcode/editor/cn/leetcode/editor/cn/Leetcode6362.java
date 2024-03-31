package leetcode.editor.cn.leetcode.editor.cn;

import leetcode.editor.cn.Leetcode6328;

import java.util.HashMap;
import java.util.Map;

public class Leetcode6362 {
    public static void main(String[] args) {
        Leetcode6362 leetcode6362 = new Leetcode6362();
        System.out.println(leetcode6362.findTheLongestBalancedSubstring("01000111"));
    }
    public int findTheLongestBalancedSubstring(String s) {
        int result = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int count = 0;
        indexMap.put(0, -1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) =='0') {
                count++;
            } else {
                count--;
            }
            if (indexMap.containsKey(count) && check(s, indexMap.get(count) + 1, i)) {
                result = Math.max(result, i - indexMap.get(count) );
            }
            indexMap.put(count, i);
        }
        return result;
    }
    public boolean check(String s, int start, int end) {
        int count = 0;
        boolean preZero = false;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '1') {
                if (i - 1 >= start && s.charAt(i - 1) == '0') {
                    count++;
                }
            } else {
                if (i - 1 >= start && s.charAt(i - 1) == '1') {
                    preZero = true;
                }
            }
        }
        return count == 1 && !preZero;
    }

}
