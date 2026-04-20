1// Best 
2class Solution {
3    public int coinChange(int[] coins, int amount) {
4
5        // dp[j] = minimum coins needed to make amount j
6        int[] dp = new int[amount + 1];
7
8        // Fill with a very large value
9        // amount + 1 is safe because answer can never be more than amount
10        Arrays.fill(dp, amount + 1);
11
12        // Base case:
13        // 0 coins needed to make amount 0
14        dp[0] = 0;
15
16        // Process every coin
17        for (int coin : coins) {
18
19            // Start from current coin value
20            for (int j = coin; j <= amount; j++) {
21
22                // Two choices:
23                // 1. Don't use current coin -> dp[j]
24                // 2. Use current coin once -> 1 + dp[j - coin]
25                dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
26            }
27        }
28
29        // If dp[amount] was never updated, answer is impossible
30        return (dp[amount] == amount + 1) ? -1 : dp[amount];
31    }
32}
33// class Solution { // space optimization
34//     public int coinChange(int[] coins, int amount) {
35//         int n = coins.length;  
36//         long[][]dp = new long[2][amount+1];
37//         for(int i=0;i<n;i++){ // ye coins.length tk chlana zaruri hai
38//             for(int j=0;j<dp[0].length;j++){ // amount == j and n == i
39//                // long skip = (i>0) ? dp[i-1][j] : base case;
40//                 long skip = (i>0) ? dp[0][j] : ((j==0) ? 0 : Integer.MAX_VALUE); // yha base case ke liye bhbi ternary use kra hmne 
41//                 if(coins[i] > j) dp[1][j] = skip;
42//                 else{
43//                     long pick = 1 + dp[1][j-coins[i]]; // isme ternary nhi lgana pda kyuki ye kabhi bhi error nhi dega index same he rhega
44//                     dp[1][j] = Math.min(pick,skip);
45//                 }
46//             }
47//             for(int j=0;j<dp[0].length;j++){
48//                 dp[0][j] = dp[1][j];
49//             }
50//         }
51        
52//         int ans = (int)dp[1][amount];
53//         if(ans==Integer.MAX_VALUE) return -1; // iska mtlab coins ka ans nhi nikla hmara
54//         else return ans;
55//     }
56// }
57// Tabulation
58// class Solution {
59//     public int coinChange(int[] coins, int amount) {
60//         int n = coins.length;
61//         long[][]dp = new long[n][amount+1];
62//         for(int i=0;i<dp.length;i++){
63//             for(int j=0;j<dp[0].length;j++){ // amount == j and n == i
64//                // long skip = (i>0) ? dp[i-1][j] : base case;
65//                 long skip = (i>0) ? dp[i-1][j] : ((j==0) ? 0 : Integer.MAX_VALUE); // yha base case ke liye bhbi ternary use kra hmne 
66//                 if(coins[i] > j) dp[i][j] = skip;
67//                 else{
68//                     long pick =1 + dp[i][j-coins[i]]; // isme ternary nhi lgana pda kyuki ye kabhi bhi error nhi dega index same he rhega
69//                     dp[i][j] = Math.min(pick,skip);
70//                 }
71//             }
72//         }
73//         int ans = (int)dp[n-1][amount];
74//         if(ans==Integer.MAX_VALUE) return -1; // iska mtlab coins ka ans nhi nikla hmara
75//         else return ans;
76//     }
77// }
78// Memoization
79// class Solution {
80//     public int coinChange(int[] coins, int amount) {
81//         int n = coins.length;
82//         long[][]dp = new long[n][amount+1];
83//         for(long[]arr:dp) Arrays.fill(arr,-1);
84//         int ans = (int)helper(0,coins,amount,dp);
85//         if(ans==Integer.MAX_VALUE) return -1; // iska mtlab coins ka ans nhi nikla hmara
86//         else return ans;
87//     }
88//     private long helper(int i , int[]coins,int amount,long[][]dp){
89//         if(i==coins.length){
90//              if(amount==0) return 0; // no more coins needed ans aa gya
91//              else return Integer.MAX_VALUE; // not a valid combination
92//         }
93//         if(dp[i][amount]!=-1) return dp[i][amount];
94//         long skip = helper(i+1,coins,amount,dp); // long isiliye bnaya kyuki 1 + Integer.MAX_VALUE error deta hai as int ki limit khatam ho jati hai
95//         if(coins[i]>amount) return dp[i][amount] = skip;
96//         else{
97//             long pick =1 + helper(i,coins,amount-coins[i],dp); // vvi step
98//             return dp[i][amount] = Math.min(skip,pick);
99//         }
100//     }
101// }