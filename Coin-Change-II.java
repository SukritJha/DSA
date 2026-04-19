1// From now on, before every DP problem, force yourself to write these 3 lines first:
2
3// 1. State:
4// dp[i] / dp[i][j] means what?
5
6// 2. Transition:
7// From where can current state come?
8
9// 3. Goal:
10// Am I minimizing, maximizing, counting ways, or checking true/false?
11class Solution {
12    public int change(int amount, int[] coins) {
13        int n = coins.length;
14        int[][]dp = new int[n][amount+1];
15        for(int[]arr:dp) Arrays.fill(arr,-1);
16       return (int)helper(0,amount,coins,dp);
17    }
18    private int helper(int i,int amount, int[]coins, int[][]dp){ //helper(i, amount) = number of ways to make amount
19        if(amount==0) return 1; // yha pe number of ways chahiye toh return 1 krna jb amount 0 bn jayega
20        if(i==coins.length) return 0;
21        if(dp[i][amount]!=-1) return dp[i][amount];
22        int skip = helper(i+1,amount,coins,dp);
23        if(coins[i]>amount) return dp[i][amount] = skip;
24        else{
25            int pick = helper(i,amount-coins[i],coins,dp);
26            return dp[i][amount] = pick + skip;
27        }
28    }
29}