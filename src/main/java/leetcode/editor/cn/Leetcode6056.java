package leetcode.editor.cn;

public class Leetcode6056 {
    public static void main(String[] args) {
        Leetcode6056 leetcode6056 = new Leetcode6056();
        System.out.println(leetcode6056.largestGoodInteger("2300019"));
    }
    public String largestGoodInteger(String num) {
        char start = '0';
        int length = 0;
        String result = "";
        int index = 0;
        while (index < num.length()) {
            char currentChar = num.charAt(index);
            length = 1;
            while (index + length < num.length() && currentChar == num.charAt(index + length)) {
                length++;
            }
            if (length >= 3 && start <= currentChar) {
                result = num.substring(index, index + 3);
                start = currentChar;
            }
            index += length;
        }
        return result;
    }
}
