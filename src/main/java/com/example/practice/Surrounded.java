package com.example.practice;

import java.util.Arrays;

public class Surrounded {
    static char[][] matrix = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}};

    public static void main(String[] args) {
        new Surrounded().solve(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        DisjointUnionSets dsu = new DisjointUnionSets(n * m + 1);

        for ( int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if((i==0||i==n-1||j==0||j==m-1)&&board[i][j]=='O') // if a 'O' node is on the boundry, connect it to the dummy node
                    dsu.union(i*m+j,n*m);
                else if (board[i][j] == 'O') {
                    if(board[i-1][j] == 'O')
                        dsu.union(i*m + j,(i-1)*m + j);
                    if(board[i][j-1] == 'O')
                        dsu.union(i*m + j,i*m + (j-1));
                    if(board[i+1][j] == 'O')
                        dsu.union(i*m + j,(i+1)*m + j);
                    if(board[i][j +1] == 'O')
                        dsu.union(i*m + j,i*m + (j+1));
                }
            }
        }

        for ( int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = (dsu.find(i*m + j) == dsu.find(n*m)) ? 'O' : 'X';
                }
            }
        }
    }

    class DisjointUnionSets {
        int[] rank, parent;
        int n;

        public DisjointUnionSets(int n) {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            makeSet();
        }

        void makeSet() {
            // Initially, all elements are in their
            // own set.
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        // Finds the representative of the set that x
        // is an element of
        int find(int x) {
            if (parent[x] != x) {
                // if x is not the parent of itself,
                // then x is not the representative of
                // its set.
                // so we recursively call Find on its parent
                // and move i's node directly under the
                // representative of this set
                return find(parent[x]);
            }

            return x;
        }

        // Unites the set that includes x and the set
        // that includes y
        void union(int x, int y) {
            // Find the representatives (or the root nodes)
            // for x an y
            int xRoot = find(x);
            int yRoot = find(y);

            // Elements are in the same set, no need
            // to unite anything.
            if (xRoot == yRoot)
                return;

            // If x's rank is less than y's rank
            // Then move x under y  so that depth of tree
            // remains less
            if (rank[xRoot] < rank[yRoot])
                parent[xRoot] = yRoot;

                // Else if y's rank is less than x's rank
                // Then move y under x so that depth of tree
                // remains less
            else if (rank[yRoot] < rank[xRoot])
                parent[yRoot] = xRoot;

            else  // Else if their ranks are the same
            {
                // Then move y under x (doesn't matter
                // which one goes where)
                parent[yRoot] = xRoot;

                // And increment the the result tree's
                // rank by 1
                rank[xRoot] = rank[xRoot] + 1;
            }
        }
    }
}
