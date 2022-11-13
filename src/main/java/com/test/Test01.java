package com.test;

import java.util.Scanner;

public class Test01 {
    public volatile int inc = 0;
    public void increase() {
        inc++;
    }
    public static void main(String[] args) {
        final Test01 test01 =new Test01();
        for (int i = 0; i < 10000; i++) {
            new Thread() {
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        test01.increase();;
                    }
                }
            }.start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(test01.inc);

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(",");
        if (strings.length == 0) {
            System.out.println("/");
            return;
        }
        if (strings.length == 1) {
            StringBuilder temp = new StringBuilder(strings[0]);
            if (temp.charAt(0) != '/') {
                temp.insert(0, '/');
            }
            System.out.println(temp.toString());
            return;
        }
        StringBuilder start = new StringBuilder(strings[0]);
        StringBuilder last = new StringBuilder(strings[1]);
        if (start.length() != 0) {
            if (start.charAt(0) != '/') {
                start.insert(0, '/');
            }
            if (start.charAt(start.length() - 1) == '/') {
                start.deleteCharAt(start.length() - 1);
            }
        }
        if (last.length() != 0) {
            if (last.charAt(0) == '/') {
                last.deleteCharAt(0);
            }
        }
        System.out.println(start.toString() + "/" + last.toString());
    }
}
