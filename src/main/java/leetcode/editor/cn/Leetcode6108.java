package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6108 {
    public static void main(String[] args) {
        Leetcode6108 leetcode6108 = new Leetcode6108();
        System.out.println(leetcode6108.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }
    public String decodeMessage(String key, String message) {
        int[] charArray = new int[26];
        Arrays.fill(charArray, -1);
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            char current = key.charAt(i);
            if (Character.isLetter(current) && charArray[current - 'a'] == -1) {
                charArray[current - 'a'] = index++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (Character.isLetter(message.charAt(i))) {
                result.append((char)(charArray[message.charAt(i) - 'a'] + 'a'));
            } else {
                result.append(message.charAt(i));
            }

        }
        return result.toString();
    }
}
