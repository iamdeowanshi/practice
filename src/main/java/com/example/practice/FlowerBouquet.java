package com.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        //System.out.println(new FlowerBouquet().canPlot(new int[]{0,1,0,0,0,0,0,0,0,1,0}, 3));
        List<List<Integer>> points = new ArrayList<>();
        List<Integer> point = new ArrayList<>();
        point.add(1);
        point.add(-3);
        points.add(point);
        point = new ArrayList<>();
        point.add(1);
        point.add(2);
        points.add(point);
        System.out.println(ClosestXdestinations(3,points, 2));
    }

    static List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries) {
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> point : allLocations) {

        }
        allLocations.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int d1 = ((o1.get(0)-0)^2 +  (o1.get(1)-0)^2)^(1/2);
                int d2 = ((o2.get(0)-0)^2 +  (o2.get(1)-0)^2)^(1/2);
                return (d1 - d2 < 0) ? d1 : d2;
            }
        });
        return allLocations.subList(0,numDeliveries);

    }


}
