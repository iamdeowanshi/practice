package com.example.practice;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberIslandII {
    public String solution(String S, int K) {
        // write your code in Java SE 8
        String input = S.replaceAll("-","").toUpperCase();
        int i = input.length();
        StringBuilder sb = new StringBuilder();
        while( i > 0) {
            sb.append(input.charAt(i));
            if (sb.length() != 0 && i % K == 0)
                sb.append("-");
        }

        return sb.reverse().toString();

    }
    public static void main(String[] args)throws IOException
    {
        int[][] a = new int[][] {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println("Number of Islands is: " +countIslands(a));
/*
//        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};


        System.out.println(isCycle(edges, 5));*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());
        int[][] input = new int[lines][];
        int index = 0;
        while( lines > 0) {
            String[] point = br.readLine().split(" ");
            int[] in = new int[]{Integer.parseInt(point[0]),Integer.parseInt(point[1])};
            input[index] = in;
            index++;
        }    }

    private static boolean isCycle(int[][] edges, int n) {
        DisjointUnionSets dus = new DisjointUnionSets(n);

        for (int[] edge : edges) {
            int x = dus.find(edge[0]);
            int y = dus.find(edge[1]);

            if (x == y)
                return true;
            dus.union(edge[0], edge[1]);

        }

        return false;
    }

    static int countIslands(int a[][])
    {
        int n = a.length;
        int m = a[0].length;

        DisjointUnionSets dus = new DisjointUnionSets(n*m);

        for (int j=0; j<n; j++)
        {
            for (int k=0; k<m; k++)
            {

                if (a[j][k] == 0)
                    continue;

                if (j+1 < n && a[j+1][k]==1)
                    dus.union(j*(m)+k, (j+1)*(m)+k);
                if (j-1 >= 0 && a[j-1][k]==1)
                    dus.union(j*(m)+k, (j-1)*(m)+k);
                if (k+1 < m && a[j][k+1]==1)
                    dus.union(j*(m)+k, (j)*(m)+k+1);
                if (k-1 >= 0 && a[j][k-1]==1)
                    dus.union(j*(m)+k, (j)*(m)+k-1);
            }
        }

        // Array to note down frequency of each set
        int[] c = new int[n*m];
        Map<Integer, Integer>  sizemap = new HashMap<>();
        int numberOfIslands = 0;
        for (int j=0; j<n; j++)
        {
            for (int k=0; k<m; k++)
            {
                if (a[j][k]==1)
                {

                    int x = dus.find(j*m+k);

                    if (c[x]==0)
                    {
                        numberOfIslands++;
                        c[x]++;
                    }

                    else
                        c[x]++;
                }
            }
        }

        for (Integer item : c){
            if (item !=0 ) {
                if (sizemap.containsKey(item))
                    sizemap.put(item, sizemap.get(item) + 1);
                else
                    sizemap.put(item, 1);
            }
        }
        int[] test = {1,2,3};
        int res[] = new int[test.length];
        int index =0;
        for(int t : test){
            res[index] = sizemap.containsKey(t) ? sizemap.get(t) : 0;
            index++;
        }

        System.out.println(Arrays.toString(res));

        return numberOfIslands;


    }
}

class DisjointUnionSets
{
    int[] rank, parent;
    int n;

    public DisjointUnionSets(int n)
    {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }

    void makeSet()
    {
        for (int i=0; i<n; i++)
            parent[i] = i;
    }

    int find(int x)
    {
        if (parent[x] != x)
        {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    void union(int x, int y)
    {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot)
            return;

        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;

        else if(rank[yRoot]<rank[xRoot])
            parent[yRoot] = xRoot;

        else
        {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
