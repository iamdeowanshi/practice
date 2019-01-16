package com.example.practice;

import java.util.ArrayList;
import java.util.List;

public class SuperUgly {

    public static int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        int k = primes.length;

        int[] index = new int[k];

        for (int i =1 ;i < n; i++) {
            int current = Integer.MAX_VALUE;
            for (int j = 0; j < k ; j++) {
                current = Math.min(current, result.get(index[j])*primes[j]);
            }

            result.add(current);

            for (int j =0 ; j< k ;j++){
                if(current == primes[j]*result.get(index[j]))
                    index[j]++;
            }
        }

        return result.get(result.size() -1);
    }

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(10, new int[]{2,3,5}));
    }
}
