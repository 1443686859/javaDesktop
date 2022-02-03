package com.test;

public class Leetcode5919 {
    public static void main(String[] args) {
        Leetcode5919 solution = new Leetcode5919();
        System.out.println(solution.countVowels("aba"));
    }
    public long countVowels(String word) {
        long result = 0;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
//                result += check(word.substring(j, i));
            }
        }
        return result;
    }

}
