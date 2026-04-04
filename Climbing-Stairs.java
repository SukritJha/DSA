1class Solution {
2    public int climbStairs(int n) {
3       int[] dp = new int[n+1];
4       Arrays.fill(dp,-1);
5       return helper(n,dp); 
6    }
7    private int helper(int n,int[]dp){
8        if(n==1) return 1;
9        if(n==2) return 2;
10        if(dp[n]!=-1) return dp[n];
11        return dp[n] =helper(n-1,dp) + helper(n-2,dp);
12    }
13}