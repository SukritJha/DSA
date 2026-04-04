1class Solution {
2    public int climbStairs(int n) {
3        // by tabulation
4        int[] dp = new int[n+1];
5        if(n==1) return 1;
6        if(n==2) return 2;
7        dp[1] = 1;
8        dp[2] = 2;
9        for(int i=3;i<=n;i++){
10            dp[i] = dp[i-1] + dp[i-2];
11        }
12        return dp[n];
13    //    int[] dp = new int[n+1];
14    //    Arrays.fill(dp,-1);
15    //    return helper(n,dp); 
16    }
17    // private int helper(int n,int[]dp){
18    //     if(n==1) return 1;
19    //     if(n==2) return 2;
20    //     if(dp[n]!=-1) return dp[n];
21    //     return dp[n] =helper(n-1,dp) + helper(n-2,dp);
22    // }
23}