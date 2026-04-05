// User function Template for Java

class Solution {
    static int countDer(int n) {
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    private static int helper(int n, int[] dp){
        if(n==1) return 0;
        if(n==2) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = (n-1)*helper(n-1,dp) + (n-1)*helper(n-2,dp);
    }
}