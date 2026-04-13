1//Memoization
2class Solution {
3    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
4        int m = obstacleGrid.length;
5        int n = obstacleGrid[0].length;
6        int[][]dp = new int[m][n];
7        for(int[]arr : dp) Arrays.fill(arr,-1);
8        return helper(m-1,n-1,obstacleGrid,dp);
9    }
10    private int helper(int i,int j,int[][]grid,int[][]dp){
11        if(i<0||j<0) return 0;
12        if(grid[i][j]==1)return 0; // obstacle
13        if(i==0&&j==0) return 1;
14        if(dp[i][j]!= -1) return dp[i][j];
15        return dp[i][j] = helper(i-1,j,grid,dp) + helper(i,j-1,grid,dp);
16    }
17}
18
19// Tabulation
20// class Solution {
21//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
22//         int m = obstacleGrid.length;
23//         int n = obstacleGrid[0].length;
24//         int[][]dp = new int[m][n];
25//         // start cell
26//         if(obstacleGrid[0][0]==1) return 0;
27//         dp[0][0] = 1;
28
29//         // first column
30//         for(int i=1;i<m;i++){
31//             if(obstacleGrid[i][0]==1) dp[i][0] = 0;
32//             else dp[i][0] = dp[i-1][0];
33//         }
34
35//         // first row
36//         for(int j=1;j<n;j++){
37//             if(obstacleGrid[0][j]==1) dp[0][j] = 0;
38//             else dp[0][j] = dp[0][j-1];
39//         }
40
41//         // rest 
42//         for(int i=1;i<m;i++){
43//             for(int j=1;j<n;j++){
44//                 if(obstacleGrid[i][j]==1) dp[i][j] =0;
45//                 else dp[i][j] = dp[i-1][j] + dp[i][j-1] ;
46//             }
47//         }
48//         return dp[m-1][n-1];
49//     }
50// }
51