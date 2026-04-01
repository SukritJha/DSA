1class Solution {
2    public int tribonacci(int n) {
3        if(n<=1) return n;
4        if(n==2) return 1;
5        int[] arr = new int[n+1];
6        arr[0] = 0; arr[1] = 1; arr[2] = 1;
7        for(int i=3;i<=n;i++){
8            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
9        }
10        return arr[n];
11        // int [] dp = new int[n+1];
12        // return helper(n,dp);
13    }
14    // private int helper(int n, int[] dp){
15    //     if(n<=1) return n;
16    //     if(n==2) return 1;
17    //     if(dp[n] != 0) return dp[n];
18    //     return dp[n] = helper(n-1,dp) + helper(n-2,dp) + helper(n-3,dp); 
19    // }
20}