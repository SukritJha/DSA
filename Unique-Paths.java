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
11          for(int j=1;j<n;j++){
12            dp[1][j] = dp[1][j-1] + dp[0][j]; // first dp wala kaam hoga
13            dp[0][j] = dp[1][j]; // ab neeche wale row lo upar copy paste krdo
14           }
15        } 
16        return dp[1][n-1];
17    }
18}    
19
20// class Solution {
21//     public int uniquePaths(int m, int n) {
22//         // now by tabulation
23//         int[][]dp = new int[m][n];
24//         for(int i=0;i<m;i++){
25//             for(int j=0;j<n;j++){
26//                 if(i==0||j==0) dp[i][j] = 1;
27//                 else dp[i][j] = dp[i][j-1] + dp[i-1][j];
28//             }
29//         }
30//         return dp[m-1][n-1];
31
32
33//     //  int [][]dp = new int[m+1][n+1];
34//     // Arrays.fill(dp,-1); you cannot use this in 2d arrays
35//     //   for(int[]arr:dp){
36//     //     Arrays.fill(arr,-1);
37//     //   }
38//      // return paths(m,n,dp);
39//      //  return helper(0,0,m-1,n-1,dp); 
40//     }
41//     // memoization M-1
42//     // private int paths(int m,int n,int[][]dp){
43//     //     if(m==1||n==1) return 1;
44//     //     if(dp[m][n] != -1) return dp[m][n];
45//     //     return dp[m][n] = paths(m,n-1,dp) + paths(m-1,n,dp);
46//     // }
47
48//     // memoization M-2
49//     // private int helper(int cr,int cl,int lr, int lc,int[][]dp){ // cr = current row , cl = current column
50//     //     if(cr>lr||cl>lc) return 0; // lr = last row, lc = last column
51//     //     if(cr==lr && cl==lc) return 1;
52//     //       if(dp[cr][cl] != -1) return dp[cr][cl];
53//     //     return dp[cr][cl] = helper(cr+1, cl,lr,lc,dp) + helper(cr,cl+1,lr,lc,dp);
54//     // }
55// }