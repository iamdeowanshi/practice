package com.example.practice;

public class FlowerBouquet {

    public static int flowerBouquets(int p, int q, String s) {
        int maxProfit = Integer.MIN_VALUE;
        char prev = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            
        }

        return  maxProfit;
    }

    boolean canPlot(int[] bed, int flower) {
        int i = 0;
        while ( i < bed.length) {
            if (bed[i] == 0) {
                if (i == bed.length - 1){
                    i++;
                    flower--;
                } else if ( bed[i+1] == 0) {
                    flower--;
                    i++;
                }
                i++;
            } else
                i+=2;
        }
        return (flower > 0) ? false : true;
    }

    public static void main(String[] args) {
        System.out.println(new FlowerBouquet().canPlot(new int[]{0,1,0,0,0,0,0,0,0,1,0}, 3));
    }
}
