class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int[][]dp = new int[n][capacity+1];
        for(int[]arr:dp) Arrays.fill(arr,-1);
        return helper(0,val,wt,capacity,dp);
    }
    private int helper(int i,int[]val,int[]wt,int capacity,int[][]dp){
        if(i==val.length) return 0;
        if(dp[i][capacity]!=-1) return dp[i][capacity];
        int skip = helper(i+1,val,wt,capacity,dp);
        if(wt[i]>capacity) return dp[i][capacity] = skip;
        else{
            int pick = val[i] + helper(i,val,wt,capacity-wt[i],dp);
            return dp[i][capacity] = Math.max(pick,skip);
        }
    }
}