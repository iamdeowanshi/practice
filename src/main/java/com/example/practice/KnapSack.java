package com.example.practice;

public class KnapSack {

    // Returns the maximum value that can be put in a knapsack of capacity W
    int bottomUpDP(int val[], int wt[], int W) {
        int[][] dp = new int[val.length+1][W+1];

        for (int i = 0; i <= dp.length ; i++) {
            for (int j = 0 ; j <= W ; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(j - wt[i-1] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[val.length][W];
    }


    // Driver program to test above function
    public static void main(String args[]){
        KnapSack k = new KnapSack();
        int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        int r = k.bottomUpDP(val, wt, 30);
        System.out.println(r);
    }

    static int consecutive(long num) {
        while ((num & 1) == 0) num /= 2;
        int count = 1, d = 3;

        while (d * d <= num) {
            int end = 0;
            while (num % d == 0) {
                num /= d;
                end++;
            }
            count *= end + 1;
            d += 2;
        }

        if (num > 1) count *= 2;
        return count -1 ;
    }
}
