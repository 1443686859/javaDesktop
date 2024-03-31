package leetcode.editor.cn;

public class Leetcode6441 {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("000"));
    }
    public int punishmentNumber(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (check("" + (i * i), 0, i)) {
                count += i * i;
            }
        }
        return count;
    }
    public boolean check(String n, int index, int target) {
        if (index == n.length() && target == 0) {
            return true;
        }
        boolean result = false;
        for (int i = index + 1; i <= n.length(); i++) {
            int current = Integer.parseInt(n.substring(index, i));
            if (current > target) {
                break;
            }
            result |= check(n, i, target - current);
        }
        return  result;
    }
}
