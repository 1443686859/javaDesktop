package leetcode.editor.cn;

public class Leetcode6152 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int add = 0;
        for (int i = 0; i < energy.length; i++) {
            if (initialEnergy <= energy[i]) {
                add += energy[i] + 1 - initialEnergy;
                initialEnergy = 1;
            } else {
                initialEnergy -= energy[i];
            }
            if (initialExperience <= experience[i]) {
                add += experience[i] + 1 - initialExperience;
                initialExperience = 2 * experience[i] + 1;
            } else {
                initialExperience += experience[i];
            }
        }
        return add;
    }
}
