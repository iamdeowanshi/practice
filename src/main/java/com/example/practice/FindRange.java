package com.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindRange {

    public static void main(String[] args) {
        int [] nums = {0,2,2,3,3,3,3,4,5,10,10};
        System.out.println(Arrays.toString(nums));
        System.out.println((findRange(nums, 3)));
    }
   static List<Integer> findRange(int[] nums, int value) {

        List<Integer> result = new ArrayList<>();
        int low = 0, high = nums.length-1;
        int valueIndex = -1;
        while (low < high) {
            int mid = (low + high) /2;

            if (nums[mid] == value) {
                valueIndex = mid;
                break;
            } else if (nums[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (valueIndex == -1) {
            result.add(-1);
            result.add(-1);

            return result;
        }
        int i = valueIndex, j = valueIndex;
       /* while (i >= 0 || j < nums.length) {
            if (i > 0) i--;
            if (j < nums.length) j++;

            if (nums[i] == value)
                i--;

            if (nums[j] == value)
                j++;
        }*/

        while (i >= 0) {
            if (nums[i] == value)
                i--;
            else break;
        }

        while (j < nums.length) {
            if (nums[j] == value)
                j++;
            else break;
        }
        result.add(++i);
        result.add(--j);
        return result;
    }
}
