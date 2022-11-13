package com.test;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        int[] result = new int[15];
        for (int i = 0; i < count; i++) {
            String current = sc.nextLine();
            if (current.charAt(0) == 'J') {
                result[0] ++;
                continue;
            }
            if (current.charAt(current.length() - 1) == 'A') {
                result[14]++;
                continue;
            }
            if (current.charAt(current.length() - 1) == 'J')  {
                result[11]++;
                continue;
            }
            if (current.charAt(current.length() - 1) == 'Q')  {
                result[12]++;
                continue;
            }
            if (current.charAt(current.length() - 1) == 'K')  {
                result[13]++;
                continue;
            }
            int index = Integer.parseInt(current.substring(1));
            result[index]++;
        }
        int resultSum = 0;
        if (result[0] == 2) {
            resultSum += 5;
            result[0] = 0;
        }
        // 判断3，4
        for (int i = 0; i < 15; i++) {
            if (result[i] == 4) {
                resultSum += 5;
                result[i] -= 4;
            } else if (result[i] == 3) {
                resultSum += 4;
                result[i] -= 3;
            }
        }
        // 判断连续, 计算点数
        int[] newArray = new int[15];
        for (int i = 2; i < 15; i++) {
            newArray[i] = result[i];
        }
        int left = 2;
        int right = 2;
        int newResult = 0;
        while (left <= right && right < 15) {
            if (right - left == 5) {
                for (int i = left; i < right; i++) {
                    newArray[i]--;
                }
                newResult += 3;
                left = right;
                right++;
            }
            if (newArray[right] >= 1) {
                right++;
            } else {
                right++;
                left = right;
            }
        }
        for (int i = 2; i < 15; i++) {
             if (newArray[i] == 2) {
                 newResult += 2;
             }
        }
        int currentResult = 0;
        for (int i = 2; i < 15; i++) {
            if (result[i] == 2) {
                currentResult += 2;
                result[i] -= 2;
            }
        }
        left = 2;
        right = 2;
        while (left <= right && right < 15) {
            if (right - left == 5) {
                for (int i = left; i < right; i++) {
                    result[i]--;
                }
                currentResult += 3;
                left = right;
                right++;
            }
            if (result[right] >= 1) {
                right++;
            } else {
                right++;
                left = right;
            }
        }
        System.out.println(resultSum + Math.max(currentResult, newResult));
    }


}
