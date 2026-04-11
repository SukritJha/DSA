1class Solution {
2    public int minPathSum(int[][] grid) {
3        // by tabulation
4    //     int m = grid.length;
5    //     int n = grid[0].length;
6    //    // int[][] dp = new int[m][n]; you can do it without creating dp array
7    //     for(int i=0;i<m;i++){
8    //         for(int j=0;j<n;j++){
9    //          if(i==0&&j==0) continue;
10    //          else if(i==0)  grid[i][j] += grid[i][j-1];
11    //          else if(j==0)  grid[i][j] += grid[i-1][j];
12    //          else grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]); 
13    //         }
14    //     }
15    //     return grid[m-1][n-1];
16        int m = grid.length;
17        int n = grid[0].length;
18        int dp[][] = new int[m][n];
19        for(int[]arr:dp){
20            Arrays.fill(arr,-1);
21        }
22        return helper(m-1,n-1,grid,dp);
23    }
24    private int helper(int i, int j, int[][] grid, int[][]dp){
25        if(i==0&&j==0) return grid[0][0];
26        if(i<0||j<0) return Integer.MAX_VALUE;
27        if(dp[i][j] != -1) return dp[i][j];
28        int down = helper(i-1,j,grid,dp);
29        int right = helper(i,j-1,grid,dp);
30        return dp[i][j] = grid[i][j] + Math.min(down,right);
31    }
32}