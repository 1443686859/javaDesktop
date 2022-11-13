package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test04 {
    public static void main(String[] args) {
        Test04 test04 = new Test04();
        System.out.println(test04.test("tree"));
        System.out.println(test04.test("cccaaa"));
        System.out.println(test04.test("Aabb"));
    }
    public String test(String target) {
        int[][] count = new int[52][3];
        for (int i = 0; i < target.length(); i++) {
            if (Character.isLowerCase(target.charAt(i))) {
                count[target.charAt(i) - 'a'][0] ++;
                count[target.charAt(i) - 'a'][1] = target.charAt(i) - 'a';
                count[target.charAt(i) - 'a'][2] = 1;
            } else {
                count[target.charAt(i) - 'A' + 26][0] ++;
                count[target.charAt(i) - 'A' + 26][1] = target.charAt(i) - 'A';
            }
        }
        Arrays.sort(count, (pre, after) ->{
            return after[0] - pre[0];
        });
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i][0] != 0) {
                char currentChar;
                if (count[i][2] == 1) {
                   currentChar = (char)('a' +  count[i][1]);
                } else {
                    currentChar = (char)('A' + count[i][1]);
                }
                for (int j = 0; j < count[i][0]; j++) {
                    result.append(currentChar);
                }
            }
        }
        return result.toString();
    }
}
