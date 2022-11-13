package leetcode.editor.cn;

import java.util.Scanner;

public class HJ63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String current = sc.nextLine();
        int length = Integer.parseInt(sc.nextLine());
        int[] count = new int[current.length()];
        int total = 0;
        int resultIndex = -1;
        int maxLength = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) == 'C' || current.charAt(i) == 'G') {
                total++;
            }
            count[i] = total;
        }
        resultIndex = 0;
        maxLength = count[length - 1];
        for (int i = length; i < current.length(); i++) {
            int currentResult = count[i] - count[i - length];
            if (currentResult > maxLength) {
                maxLength = currentResult;
                resultIndex = i - length + 1;
            }
        }
        System.out.println(current.substring(resultIndex, resultIndex + length));
    }
}
