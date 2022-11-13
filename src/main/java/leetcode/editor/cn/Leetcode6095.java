package leetcode.editor.cn;

public class Leetcode6095 {
    boolean is = false;
    boolean big = false;
    boolean num = false;
    String special = "!@#$%^&*()-+";
    boolean isSpecial = false;

    public boolean strongPasswordCheckerII(String password) {
        is = false;
        big = false;
        num = false;
        isSpecial = false;
        if (password.length() < 8) {
            return false;
        }
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }
            check(password.charAt(i));
        }
        check(password.charAt(password.length() - 1));
        if (!is || !big || !num || !isSpecial) {
            return false;
        }
        return true;
    }
    public void check(char c) {
        if (Character.isDigit(c)) {
            num = true;
            return;
        }
        if (Character.isLetter(c)) {
            if (Character.isLowerCase(c)) {
                is = true;
                return ;
            }
            if (Character.isUpperCase(c)) {
                big = true;
                return;
            }
        }
        if (special.indexOf(c) != -1) {
            isSpecial = true;
            return ;
        }
    }
}
