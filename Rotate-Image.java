1class Solution {
2    public void rotate(int[][] matrix) {
3        for(int i=0;i<matrix.length;i++){
4            for(int j=0;j<i;j++){
5                int temp = matrix[i][j];
6                matrix[i][j] = matrix[j][i];
7                matrix[j][i] = temp;
8            }
9        }
10        // now reverse this transpose
11        for(int i=0;i<matrix.length;i++){
12              int startcol = 0;
13              int endcol = matrix[0].length-1;
14              while(startcol<endcol){
15                int temp = matrix[i][startcol];
16                matrix[i][startcol] = matrix[i][endcol];
17                matrix[i][endcol] = temp;
18                startcol++;
19                endcol--;
20              }
21        }
22    }
23}