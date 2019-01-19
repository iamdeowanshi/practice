package com.example.practice;

import java.util.Arrays;

public class CalculateSum {

    static int sum(int arr[][], int p,int q, int r, int s) {
        int sum = 0;
        for( int i = p ; i <= r ; i++) {
            for (int j = q ; j <= s ; j++) {
                sum += arr[i][j];
            }
        }

        return sum;
    }

    static int optimizedSum(int arr[][], int p,int q, int r, int s) {
        int sum = 0;
        sum = arr[r][s] - arr[r][q-1] - arr[p-1][s] + arr[p-1][q-1];

        return  sum;
    }

    static void optimize(int[][] arr) {
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0 ;j < arr[0].length ; j++) {

                if (i == 0 && j == 0){
                    arr[i][j] = arr[i][j];
                } else if( i == 0) {
                    arr[i][j] = arr[i][j] + arr[i][j-1];
                }else if ( j == 0){
                    arr[i][j] = arr[i-1][j] + arr[i][j];
                } else {
                    arr[i][j] = arr[i-1][j] + arr[i][j] + arr[i][j-1] - arr[i-1][j-1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(sum(matrix,0,0,2,2));
        optimize(matrix);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(optimizedSum(matrix,1,1,2,2));

    }
}
