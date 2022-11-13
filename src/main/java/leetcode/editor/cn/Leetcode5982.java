package leetcode.editor.cn;

public class Leetcode5982 {
    public static void main(String[] args) {
        Leetcode5982 solution = new Leetcode5982();
        System.out.println(solution.mostPoints(new int[][]{{3,2},{4,3},{4,4},{2,5}}));
    }
    public long mostPoints(int[][] questions) {
        int current = 0;
        return max(questions, 0, current);
    }
    public long max(int[][] questions, int index, int current) {
        if (index >= questions.length) {
            return current;
        }
        if (index + questions[index][1] + 1 >= questions.length) {
            return current +  questions[index][0];
        }
        long choosed = max(questions, index + questions[index][1] + 1, current + questions[index][0]);
        long unChoosed =  max(questions, index + 1, current);
        return Math.max(choosed, unChoosed);
    }
}
