package leetcode.editor.cn;

public class Leetcode6055 {
    public static void main(String[] args) {
        Leetcode6055 leetcode6055 = new Leetcode6055();
        System.out.println(leetcode6055.convertTime("02:30",
                "04:35"));
    }
    public int convertTime(String current, String correct) {
        String[] currentArray = current.split(":");
        String[] correctArray = correct.split(":");
        int result = 0;
        result += Integer.valueOf(correctArray[0]) - Integer.valueOf(currentArray[0]);
        int temp = Integer.valueOf(correctArray[1]) - Integer.valueOf(currentArray[1]);
        if (temp < 0) {
            temp += 60;
            result--;
        }
        if (temp >= 15) {
            result += temp / 15;
            temp = temp % 15;
        }
        if (temp >= 5) {
            result += temp / 5;
            temp = temp % 5;
        }
        result += temp;
        return result;
    }
}
