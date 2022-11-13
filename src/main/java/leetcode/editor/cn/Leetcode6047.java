package leetcode.editor.cn;

import java.util.PriorityQueue;

public class Leetcode6047 {
    public static void main(String[] args) {
        Leetcode6047 leetcode6047 = new Leetcode6047();
        System.out.println(leetcode6047.removeDigit("1231", '1'));
    }
    public String removeDigit(String number, char digit) {
        PriorityQueue<String> current = new PriorityQueue<>((a, b) -> {
            return b.compareTo(a);
        });
        char[] currentChars = number.toCharArray();
        for (int i = 0; i < currentChars.length; i++) {
            if (digit == currentChars[i]) {
                StringBuilder currentBuilder = new StringBuilder(number);
                currentBuilder.deleteCharAt(i);
                current.add(currentBuilder.toString());
            }
        }
        return current.peek();
    }
}
