1class Solution {
2    public int change(int amount, int[] coins) {
3        int n = coins.length;
4        int[][]dp = new int[n][amount+1];
5        for(int[]arr:dp) Arrays.fill(arr,-1);
6       return (int)helper(0,amount,coins,dp);
7       
8    }
9    private int helper(int i,int amount, int[]coins, int[][]dp){
10        if(amount==0) return 1;
11        if(i==coins.length) return 0;
12        if(dp[i][amount]!=-1) return dp[i][amount];
13        int skip = helper(i+1,amount,coins,dp);
14        if(coins[i]>amount) return dp[i][amount] = skip;
15        else{
16            int pick = helper(i,amount-coins[i],coins,dp);
17            return dp[i][amount] = pick + skip;
18        }
19    }
20}