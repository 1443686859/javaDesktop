package leetcode.editor.cn;

public class Leetcode6093 {
    class TextEditor {
        StringBuilder current;
        int currentIndex;
        public TextEditor() {
            current = new StringBuilder();
            currentIndex = 0;
        }

        public void addText(String text) {
            int targetIndex = 0;
            if (currentIndex >= current.length()) {
                for (int i = current.length(); i < currentIndex; i++) {
                    current.append(' ');
                }
            } else {
                targetIndex = currentIndex;
            }
            currentIndex += text.length();
            current.insert(targetIndex, text);
        }

        public int deleteText(int k) {
            return 0;

        }

        public String cursorLeft(int k) {
return null;
        }

        public String cursorRight(int k) {
            return null;
        }
    }
}
