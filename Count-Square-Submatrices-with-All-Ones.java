1class Solution {
2    public int countSquares(int[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5        int count = 0;
6        for(int i=0;i<m;i++){
7            for(int j=0;j<n;j++){
8                if(i==0||j==0) continue;
9                else if(matrix[i][j]==0) continue;
10                else{
11                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j] , Math.min(matrix[i][j-1] , matrix[i-1][j-1]));
12                }
13            }
14        }
15        for(int i=0;i<m;i++){
16            for(int j=0;j<n;j++){
17              count += matrix[i][j];
18            }
19        }
20        return count;
21    }
22    // private int helper(int i;int j;int[][]arr,int[][]dp){
23    //     if(i==0&&j==0&& arr[0][0==1]) return 1;
24    //     if(i<0 || j<0) return 0;
25    //     if(dp[i][j] != -1) return dp[i][j];
26    //     if(arr[i][j]==0) return 0;
27    //     if(arr[i][j]==1){
28    //         return dp[i][j] = helper(i,j-1,arr,dp)
29    //     }
30    //}
31}