package com.test;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String current = in.nextLine();
        StringBuilder result = new StringBuilder();
        int index = 0;
        int n = current.length();
        boolean isPositive = true;
        while (index < n) {
            char currentChar = current.charAt(index);
            if (Character.isDigit(currentChar)) {
                if (result.length() == 0) {
                    result.append(currentChar);
                } else {
                    String currentString = currentChar + "";
                    if (result.charAt(0) == '-') {
                        if (currentString.compareTo(result.substring(1)) > 0) {
                            result = sub(currentString.toString(), result.substring(1));
                        } else {
                            result = sub(result.substring(1), currentString.toString());
                        }
                    } else {
                        add(result, currentChar);
                    }

                }
            } else if (currentChar == '-') {
                index++;
                StringBuilder currentResult = new StringBuilder();
                boolean isNotZero = false;
                while (index < n && Character.isDigit(current.charAt(index))) {
                    if (current.charAt(index) != '0') {
                        isNotZero = true;
                    }
                    if (isNotZero) {
                        currentResult.append(current.charAt(index));
                    }
                    index++;
                }
                if (currentResult.toString().compareTo(result.toString()) > 0) {
                    result = sub(currentResult.toString(), result.toString());

                } else {
                    result = sub(result.toString(), currentResult.toString());
                }
            }
            index++;
        }
        System.out.println(result);
    }
    public static StringBuilder add(StringBuilder result, char current) {
        int inc = current - '0';
        int resultIndex = result.length() - 1;
        while (resultIndex >= 0 && inc != 0) {
            int resultInteger = result.charAt(resultIndex)  - '0';
            result.setCharAt(resultIndex,  Character.forDigit((resultInteger + inc) % 10, 10));
            inc = (resultInteger + inc) / 10;
            resultIndex --;
        }
        return result;
    }


    public static StringBuilder sub(String result, String current) {
        // 时刻保证 result 大于current
        StringBuilder stringBuilder = new StringBuilder(result);
        int currentIndex = current.length() - 1;
        int resultIndex = result.length() - 1;
        int inc = 0;
        while (resultIndex >= 0 && currentIndex >= 0) {
            int currentInteger = current.charAt(currentIndex) - '0';
            int resultInteger = result.charAt(resultIndex)  - '0';
            if (inc != 0) {
                resultInteger -= inc;
            }
            if (resultInteger < currentInteger) {
                resultInteger += 10;
                inc = 1;
            } else {
                inc = 0;
            }
            stringBuilder.setCharAt(resultIndex, Character.forDigit((resultInteger - currentInteger) % 10, 10));
            resultIndex --;
            currentIndex--;
        }
        while (resultIndex >= 0 && inc != 0) {
            int resultInteger = result.charAt(resultIndex)  - '0';
            if (inc != 0) {
                resultInteger -= inc;
            }
            if (resultInteger < 0) {
                resultInteger += 10;
                inc = 1;
            } else {
                inc = 0;
            }
            stringBuilder.setCharAt(resultIndex,  Character.forDigit((resultInteger) % 10, 10));
            resultIndex --;
        }
        return stringBuilder;
    }
}
