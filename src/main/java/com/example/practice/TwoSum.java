package com.example.practice;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        //twoSum();
    }

    public static void twoSum(List<Integer> nums, int target) {
        Collections.sort(nums);
        int sum = 0;
        for (Integer num : nums) {

        }
    }

    public static void threeSum(List<Integer> nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

    }

    public List<Integer> nSum(List<Integer> nums, int target, List<Integer> res, int n) {
        if (res.size() == n)
            return res;

        for (int i = 0; i < nums.size() ; i ++) {
            int num = nums.get(i);
            if (num < target) {
                res.add(nums.get(i));
                nSum(nums.subList(i+1, nums.size()), target- num, res, n);
            }

            res.remove(num);
        }

        return  res;

    }

}
