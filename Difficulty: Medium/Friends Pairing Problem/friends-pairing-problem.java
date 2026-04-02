// User function Template for Java

class Solution {
    public long countFriendsPairings(int n) {
        // code here
        long[]dp = new long[n+1];
        Arrays.fill(dp,-1);
        return pair(n,dp);
    }
    private long pair(int i,long[] dp){
        if(i<=2) return i;
        if(dp[i] != -1) return dp[i];
        return dp[i] = pair(i-1,dp) + (i-1)*pair(i-2,dp);
    }
}
