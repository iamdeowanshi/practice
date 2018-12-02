package com.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class noOfDoorOpen {

    public void noOfDoor(int n) {
        boolean[] doors = new boolean[n];

        for (int i = 0; i < n ; i++) {
            for (int j = 0 ; j < n ;j++) {

                if(i*j < n)
                    doors[j*i] = !doors[j*i];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ;i < n ; i++)
            if (doors[i])
                res.add(i);
        System.out.println(res);
    }

    public static void main(String[] args) {
        //new noOfDoorOpen().noOfDoor(100);
        //totalOpenLocker(10);
        System.out.println(largestNumberPriorityQueue(new int[]{7,8,1,5,3}, 3));
    }

    public static int totalOpenLocker(int n) {
        int totalOpen = 0 ;

        // 0 is closed
        // 1 is opened
        boolean[] lockers = new boolean[n];

        for (int i = 0 ; i < lockers.length; i++) {
            int j = 0;
            while (j < lockers.length) {
                if (i!=0 && j*i < n)
                lockers[j*i] = !lockers[j*i];
                j++;
            }
        }
        for (int i = 1 ; i < lockers.length; i++) {
            if (lockers[i]) {
                System.out.println(i);
                totalOpen++;
            }
        }
        return totalOpen ;
    }

    public static int largestNumberPriorityQueue(int[] n, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0 ; i <  n.length;i++) {
            if (queue.size() == k) {
                queue.poll();
            }
            queue.add(n[i]);
        }

        return queue.peek();
    }
}