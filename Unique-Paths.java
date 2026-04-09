1class Solution {
2    public int uniquePaths(int m, int n) {
3        // now by tabulation
4        int[][]dp = new int[m][n];
5        for(int i=0;i<m;i++){
6            for(int j=0;j<n;j++){
7                if(i==0||j==0) dp[i][j] = 1;
8                else dp[i][j] = dp[i][j-1] + dp[i-1][j];
9            }
10        }
11        return dp[m-1][n-1];
12
13
14    //  int [][]dp = new int[m+1][n+1];
15    // Arrays.fill(dp,-1); you cannot use this in 2d arrays
16    //   for(int[]arr:dp){
17    //     Arrays.fill(arr,-1);
18    //   }
19     // return paths(m,n,dp);
20     //  return helper(0,0,m-1,n-1,dp); 
21    }
22    // memoization M-1
23    // private int paths(int m,int n,int[][]dp){
24    //     if(m==1||n==1) return 1;
25    //     if(dp[m][n] != -1) return dp[m][n];
26    //     return dp[m][n] = paths(m,n-1,dp) + paths(m-1,n,dp);
27    // }
28
29    // memoization M-2
30    // private int helper(int cr,int cl,int lr, int lc,int[][]dp){ // cr = current row , cl = current column
31    //     if(cr>lr||cl>lc) return 0; // lr = last row, lc = last column
32    //     if(cr==lr && cl==lc) return 1;
33    //       if(dp[cr][cl] != -1) return dp[cr][cl];
34    //     return dp[cr][cl] = helper(cr+1, cl,lr,lc,dp) + helper(cr,cl+1,lr,lc,dp);
35    // }
36}