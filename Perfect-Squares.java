1class Solution {
2    // by better tabulation O(n√n)
3    public int numSquares(int n) {
4        int [] dp = new int[n+1];
5        for(int i=1;i<=n;i++){
6            if(isPerfect(i)) dp[i] = 1;
7            else{
8                int min = Integer.MAX_VALUE;
9                for(int j=1;j*j<i;j++){
10                 int count = dp[j*j] + dp[i-j*j];
11                 min = Math.min(min,count);
12                }
13                dp[i] = min;
14            }
15        }
16        return dp[n];
17    }
18    private boolean isPerfect(int n){
19        int sqrt = (int)(Math.sqrt(n)); // typecasting
20        return (n==sqrt*sqrt); // it will give true or false
21    }
22}
23
24
25// class Solution {
26//     // by tabulation
27//     public int numSquares(int n) { // this is also O(n^2) but still accepted because tabulation is slightly better than memoization you can learn this one also but its not the best solution
28//         int [] dp = new int[n+1];
29//         for(int i=1;i<=n;i++){
30//             if(isPerfect(i)) dp[i] = 1;
31//             else{
32//                 int min = Integer.MAX_VALUE;
33//                 for(int j=1;j<=i/2;j++){
34//                  int count = dp[j] + dp[i-j];
35//                  min = Math.min(min,count);
36//                 }
37//                 dp[i] = min;
38//             }
39//         }
40//         return dp[n];
41//     }
42//     private boolean isPerfect(int n){
43//         int sqrt = (int)(Math.sqrt(n)); // typecasting
44//         return (n==sqrt*sqrt); // it will give true or false
45//     }
46// }
47
48// better memoization
49// class Solution {
50//     public int numSquares(int n) {
51//         int [] dp = new int[n+1];
52//         Arrays.fill(dp,-1);
53//         return helper(n,dp);
54//     }
55//     private int helper(int n,int[]dp){
56//         if(isPerfect(n)) return 1; // if n is itself a perfect square then answer is always 1
57//         int min = Integer.MAX_VALUE;
58//         if(dp[n]!=-1) return dp[n];
59//         for(int i=1;i*i<=n;i++){   //loop is till i*i<n
60//             int count = helper(i*i,dp) + helper(n-i*i,dp); // by doimg this unnecessary cases are eliminated 
61//              min = Math.min(min,count); // because of this TC is now O(nroot(n)) or O(n^3/2)
62//         }
63//         return dp[n] =  min;
64//     }
65//     private boolean isPerfect(int n){
66//         int sqrt = (int)(Math.sqrt(n)); // typecasting
67//         return (n==sqrt*sqrt); // it will give true or false
68//     }
69// }
70
71// memoizatoin method but it will give tle 
72// class Solution {
73//     public int numSquares(int n) {
74//         int [] dp = new int[n+1];
75//         Arrays.fill(dp,-1);
76//         return helper(n,dp);
77//     }
78//     private int helper(int n,int[]dp){
79//         if(isPerfect(n)) return 1; // if n is itself a perfect square then answer is always 1
80//         int min = Integer.MAX_VALUE;
81//         if(dp[n]!=-1) return dp[n];
82//         for(int i=1;i<=n/2;i++){   //ye smjhe n/2 tk kyu chla loop
83//             int count = helper(i,dp) + helper(n-i,dp);
84//              min = Math.min(min,count); 
85//         }
86//         return dp[n] =  min;
87//     }
88//     private boolean isPerfect(int n){
89//         int sqrt = (int)(Math.sqrt(n)); // typecasting
90//         return (n==sqrt*sqrt); // it will give true or false
91//     }
92// }