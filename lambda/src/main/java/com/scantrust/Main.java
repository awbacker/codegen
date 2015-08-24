package com.scantrust;

public class Main {
    public static void main(String[] args) {
        String result = MessageGen.generateMessage(
                new int[]{10, 3, 3, 3, 3, 7, 10, 6},
                new double[]{1, 4.0f, 4.0f, 6.0f, 6.0f, 20, 8, 7}
        );
        System.out.println("result = " + result);
    }
}
