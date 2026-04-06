1class Solution {
2    public int[][] transpose(int[][] matrix) {
3        int row = matrix.length;
4        int col = matrix[0].length;
5        int[][]b = new int [col][row]; // normal 2d array is in row*col format
6        for(int j=0;j<b[0].length;j++){
7            for(int i=0;i<b.length;i++){
8                b[i][j] = matrix[j][i];
9            }
10        }
11        return b;
12    }
13}