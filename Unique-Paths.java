1// space optimization 
2class Solution {
3    public int uniquePaths(int m, int n) {
4        // now by tabulation
5        int[][]dp = new int[2][n];
6        for(int j=0;j<n;j++){
7            dp[0][j] = 1;
8            dp[1][j] = 1; 
9        }
10        for(int i=1;i<m;i++){// loop m-1 times chalega
11        // first dp wala kaam hoga
12          for(int j=1;j<n;j++){
13            dp[1][j] = dp[1][j-1] + dp[0][j];
14            dp[0][j] = dp[1][j];
15           }
16        } 
17        return dp[1][n-1];
18    }
19}    
20
21// class Solution {
22//     public int uniquePaths(int m, int n) {
23//         // now by tabulation
24//         int[][]dp = new int[m][n];
25//         for(int i=0;i<m;i++){
26//             for(int j=0;j<n;j++){
27//                 if(i==0||j==0) dp[i][j] = 1;
28//                 else dp[i][j] = dp[i][j-1] + dp[i-1][j];
29//             }
30//         }
31//         return dp[m-1][n-1];
32
33
34//     //  int [][]dp = new int[m+1][n+1];
35//     // Arrays.fill(dp,-1); you cannot use this in 2d arrays
36//     //   for(int[]arr:dp){
37//     //     Arrays.fill(arr,-1);
38//     //   }
39//      // return paths(m,n,dp);
40//      //  return helper(0,0,m-1,n-1,dp); 
41//     }
42//     // memoization M-1
43//     // private int paths(int m,int n,int[][]dp){
44//     //     if(m==1||n==1) return 1;
45//     //     if(dp[m][n] != -1) return dp[m][n];
46//     //     return dp[m][n] = paths(m,n-1,dp) + paths(m-1,n,dp);
47//     // }
48
49//     // memoization M-2
50//     // private int helper(int cr,int cl,int lr, int lc,int[][]dp){ // cr = current row , cl = current column
51//     //     if(cr>lr||cl>lc) return 0; // lr = last row, lc = last column
52//     //     if(cr==lr && cl==lc) return 1;
53//     //       if(dp[cr][cl] != -1) return dp[cr][cl];
54//     //     return dp[cr][cl] = helper(cr+1, cl,lr,lc,dp) + helper(cr,cl+1,lr,lc,dp);
55//     // }
56// }