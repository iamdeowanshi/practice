package com.example.practice;

import java.util.Arrays;

public class KEmptySlot {
    public static void main(String[] args) {
        System.out.println( kEmptySlots(new int[]{1,4,3,2}, 1));
    }

    public static int kEmptySlots(int[] days, int k) {
        //int[] days = new int[flowers.length];
        //for (int i = 0; i < flowers.length; i++) days[flowers[i] - 1] = i + 1;

        int left = 0, right = k + 1, result = Integer.MAX_VALUE;
        for (int i = 0; right < days.length; i++) {
            if (days[i] < days[left] || days[i] <= days[right]) {
                if (i == right)
                    result = Math.min(result, Math.max(days[left], days[right]));
                left = i;
                right = k + 1 + i;
            }
        }

        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}
