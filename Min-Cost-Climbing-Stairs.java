1class Solution {
2    // private int minCost(int[] cost, int idx, int[]dp){
3    //     if(idx<=1) return cost[idx];
4    //     if(dp[idx] > -1) return dp[idx];
5    //     return dp[idx] = cost[idx] + Math.min(minCost(cost,idx-1,dp), minCost(cost,idx-2,dp));
6    // }
7    public int minCostClimbingStairs(int[] cost) {
8        // using memoization
9        // here n is changing drom n-1/n-2 to 0/1 so we will make dp array and store values taki kum calls lage
10        // int n = cost.length;
11        // int[] dp = new int[n];
12        // Arrays.fill(dp,-1);
13        // return Math.min(minCost(cost,n-1,dp) , minCost(cost,n-2,dp));
14
15        // Tabulation
16        int n = cost.length;
17        int[] arr = new int[n];
18        arr[0] = cost[0];
19        arr[1] = cost[1];
20        for(int i=2;i<n;i++){
21            arr[i] = cost[i] + Math.min(arr[i-1] , arr[i-2]);
22        }
23        return Math.min(arr[n-1],arr[n-2]);
24    }
25}