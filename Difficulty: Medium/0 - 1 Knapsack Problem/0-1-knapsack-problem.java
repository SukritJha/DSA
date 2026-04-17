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


// public class knapsack {
//     public static void main(String[] args) {
//         int[] val = {5,3,9,16};
//         int[] weight = {1,2,8,10};
//         int cap = 8; // capacity
//         int n = val.length;
//         int[][] dp = new int [n][cap+1]; // n-> 0 to n-1 and cap = cap to 0
//         for(int[] arr : dp) Arrays.fill(arr,-1);
//         System.out.println(profit(0,val,weight,cap,dp));
//     }

//     private static int profit(int i, int[] val, int[] weight, int cap,int[][]dp) {
//         if(i==val.length) return 0;
//         if(dp[i][cap]!=-1) return dp[i][cap];
//         int skip = profit(i+1,val,weight,cap,dp);
//         if(weight[i]>cap) return dp[i][cap] = skip;
//         int take = val[i] + profit(i + 1, val, weight, cap - weight[i],dp);
//         return dp[i][cap] = Math.max(skip, take);
//     }
// }