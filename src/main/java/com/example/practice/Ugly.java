package com.example.practice;

import java.util.ArrayList;
import java.util.List;

public class Ugly {

    public static int nthUglyNumber(int n) {
        List<Integer> ugly = new ArrayList<>();
        List<Integer> non_ugly = new ArrayList<>();
        int k = 1;
        while (ugly.size() < n) {
            int i = k;
            while (i >= 1) {
                if (i % 2 == 0)
                    i = i / 2;
                else if (i % 3 == 0)
                    i = i / 3;
                else if (i % 5 == 0)
                    i = i / 5;
                else if (ugly.contains(i) || i==1) {
                    ugly.add(k);
                    break;
                }
                else {
                    non_ugly.add(k);
                    break;
                }

            }
            k++;
        }

        return ugly.get(ugly.size() -1);
    }

    public static void main(String[] args) {
        System.out.println(Ugly.nthUglyNumber(12));
    }
}
