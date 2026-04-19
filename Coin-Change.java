1class Solution {
2    public int coinChange(int[] coins, int amount) {
3        int n = coins.length;
4        long[][]dp = new long[n][amount+1];
5        for(long[]arr:dp) Arrays.fill(arr,-1);
6        int ans = (int)helper(0,coins,amount,dp);
7        if(ans==Integer.MAX_VALUE) return -1; // iska mtlab coins ka ans nhi nikla hmara
8        else return ans;
9    }
10    private long helper(int i , int[]coins,int amount,long[][]dp){
11        if(i==coins.length){
12             if(amount==0) return 0; // no more coins needed ans aa gya
13             else return Integer.MAX_VALUE; // not a valid combination
14        }
15        if(dp[i][amount]!=-1) return dp[i][amount];
16        long skip = helper(i+1,coins,amount,dp); // long isiliye bnaya kyuki 1 + Integer.MAX_VALUE error deta hai as int ki limit khatam ho jati hai
17        if(coins[i]>amount) return dp[i][amount] = skip;
18        else{
19            long pick =1 + helper(i,coins,amount-coins[i],dp); // vvi step
20            return dp[i][amount] = Math.min(skip,pick);
21        }
22    }
23}