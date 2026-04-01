1class Solution {
2    public int tribonacci(int n) {
3        int [] dp = new int[n+1];
4        return helper(n,dp);
5    }
6    private int helper(int n, int[] dp){
7        if(n<=1) return n;
8        if(n==2) return 1;
9        if(dp[n] != 0) return dp[n];
10        return dp[n] = helper(n-1,dp) + helper(n-2,dp) + helper(n-3,dp); 
11    }
12}