package com.example.practice;

public class Reverse {

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse("abcd"));
    }

    String reverse(String input) {
        if ( input.length() < 2) {
            return input;
        }
        return reverse(input.substring(1)) + input.charAt(0);
    }
}
