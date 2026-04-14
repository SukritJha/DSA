1class Solution {
2// space optimization
3    public int fib(int n) {
4        if(n<=1) return n;
5        int [] dp = new int[3];
6        dp[0] = 0;
7        dp[1] = 1;
8        for(int i =2;i<=n;i++){
9            dp[2] = dp[0] + dp[1];
10            dp[0] = dp[1]; // next time ke liye
11            dp[1] = dp[2];
12        }
13        return dp[2];
14    }
15}
16// class Solution {
17//    // static int[] dp;
18//     public int fib(int n) {
19//         if(n<=1) return n;
20//         int [] arr = new int[n+1];
21//         arr[0] = 0;
22//         arr[1] = 1;
23//         for(int i =2;i<=n;i++){
24//             arr[i] = arr[i-1] + arr[i-2];
25//         }
26//         return arr[n];
27//         // if(n==0) return 0;
28//         // if(n==1) return 1;
29//         // if(n<=1) return n;
30//         // return fib(n-1) + fib(n-2);
31//         // better solution using dp
32//     //    int[] memo = new int[n+1]; 
33//     //    return helper(n,memo); // helper function
34//     }
35//     // public int helper(int n , int[]memo){
36//     //     if(n<=1) return n;
37//     //     if(memo[n]!=0) return memo[n];
38//     //     // int ans = helper(n-1 , memo) + helper(n-2 , memo);
39//     //     // memo[n] = ans;
40//     //     // return ans;
41//     //     // you can short it also
42//     //     return memo[n] = helper(n-1,memo) + helper(n-2,memo);
43//     // }
44// }