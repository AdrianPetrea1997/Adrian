package org.example;

public class ReverseString {
    public static void main(String[] args) {
        String input = "SEX CU BABA";
        StringBuilder input1 = new StringBuilder(input);
        //input1.append (input1);
        input1.reverse();
        System.out.println(input1);
    }
}
