package com.test;

import java.util.HashMap;
import java.util.Map;

public class Leetcode5918 {
    public static void main(String[] args) {
        Leetcode5918 solution = new Leetcode5918();
        System.out.println(solution.countVowelSubstrings("aeiouu"));
    }
    public int countVowelSubstrings(String word) {
        int length = word.length();
        int result = 0;
        for (int i = 5; i <= length; i++) {
            for (int j = 0; j <= i - 5; j++) {
                if (check(word.substring(j, i))) {
                    result++;
                }
            }
        }
        return result;
    }
    public boolean check(String str) {
        Map<Character, Integer> result = new HashMap<>();
        for (Character ch : str.toCharArray()) {
            result.put(ch, result.getOrDefault(ch, 0) + 1);
        }
        if (result.size() != 5) {
            return false;
        }
        return result.containsKey('a') && result.containsKey('i') && result.containsKey('o') && result.containsKey('u') && result.containsKey('e');
    }
}
