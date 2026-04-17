class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return helper(0,W,val,wt,dp);
    }
    private int helper(int i,int W, int[] val,int[] wt, int[][]dp){
        if(i==val.length) return 0;
        if(dp[i][W]!=-1) return dp[i][W];
        int skip = helper(i+1,W,val,wt,dp);
        if(W<wt[i]) return dp[i][W] = skip;
        int take = val[i] + helper(i+1,W-wt[i],val,wt,dp);
        return dp[i][W] = Math.max(take,skip);
    }
}
