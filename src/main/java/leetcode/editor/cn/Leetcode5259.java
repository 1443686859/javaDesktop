package leetcode.editor.cn;

public class Leetcode5259 {
    public static void main(String[] args) {
        Leetcode5259 leetcode5259 = new Leetcode5259();
        System.out.println(leetcode5259.calculateTax(new int[][]{{3,50},{7,10},{12,25}}, 10));
    }
    public double calculateTax(int[][] brackets, int income) {
        double result = 0;
        int base = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (income < base) {
                break;
            } else {
                result +=(Math.min(brackets[i][0], income) - base) * (double)brackets[i][1] / 100;
            }
            base = brackets[i][0];
        }
        return result;
    }
}
