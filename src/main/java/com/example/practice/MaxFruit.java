package com.example.practice;

public class MaxFruit {

    public static void main(String[] args) {
        System.out.println(new MaxFruit().maxFruit(new int[]{1, 2, 1, 3, 4, 3, 5, 1, 2}));
        System.out.println(new MaxFruit().maxFruit(new int[]{1, 2, 1, 3, 1, 3, 1, 2}));
        System.out.println(new MaxFruit().maxFruit(new int[]{1, 2, 1, 1, 1, 3, 1, 1}));
        System.out.println(new MaxFruit().maxFruit(new int[]{1, 2, 1, 2, 1, 1, 1, 2}));
        System.out.println(new MaxFruit().maxFruit(new int[]{1, 2, 3, 4, 5, 6}));
    }

    int solution(int[] A) {
        int basket1=A[0], basket2 =A[0];
        int count =2, max = Integer.MIN_VALUE;
        for(int i =2; i < A.length ; i++) {
            if (basket1 == basket2)
                basket2 = A[i];
            if (A[i] == basket1 || A[i] == basket2)
                count++;
            else {
                max = Math.max(max, count);
                count = 2;
                basket1 = A[i];
                if (i < A.length - 1)
                    basket2 = A[i+1];
                i++;
            }
        }

        return Math.max(count,max);
    }

    int maxFruit(int[] A) {
        int basket1 = A[0], basket2 = A[0];
        int count = 1,max = Integer.MIN_VALUE;

        for( int i = 1; i < A.length; i++) {
            if (basket1 == basket2)
                basket2 = A[i];
            if (A[i] == basket1 || A[i] == basket2)
                count++;
            else {
                max = Math.max(max, count);
                if (i < A.length - 1 && A[i+1] != A[i-1]) {
                    count = 1;
                } else {
                    count = 2;
                    int j = i;
                    while(j > 1 && A[j-2] == A[j-1]) {
                        count++;
                        j--;
                    }
                }
                basket2 = A[i];
                basket1 = A[i-1];
            }
        }

        return Math.max(count,max);
    }
}
