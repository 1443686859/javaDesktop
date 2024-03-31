package leetcode.editor.cn;

public class Leetcode6287 {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = false;
        boolean isHeavy = false;
        int base = 10000;
        int baseV= (int)1e9;
        if (height >= base || width >= base || length >= base || (1l * height * width * length) >= baseV) {
            isBulky = true;
        }
        if (mass >= 100) {
            isHeavy = true;
        }
        if (isBulky && isHeavy) {
            return "Both";
        }
        if (!isHeavy && !isBulky) {
            return "Neither";
        }
        if (isBulky) {
            return "Bulky";
        }
        if (isHeavy) {
            return "Heavy";
        }
        return "";
    }
}
