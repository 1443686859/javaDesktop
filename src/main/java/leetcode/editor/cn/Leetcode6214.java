package leetcode.editor.cn;

public class Leetcode6214 {
    public static void main(String[] args) {
        Leetcode6214 leetcode6214 = new Leetcode6214();
        System.out.println(leetcode6214.haveConflict(new String[]{"01:15","02:00"}, new String[]{"02:00","03:00"}));
    }
    public boolean haveConflict(String[] event1, String[] event2) {
        if (event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0) {
            return false;
        }
        return true;
    }
}
