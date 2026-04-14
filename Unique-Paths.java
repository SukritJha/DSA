1// space optimization another way
2class Solution {
3    public int uniquePaths(int m, int n) {
4        int[][]dp = new int[2][n]; // 2Xn ka dp array bnaya
5        for(int j=0;j<n;j++){  // ab isme hr jagah 1 daal diya
6            dp[0][j] = 1;
7            dp[1][j] = 1; 
8        }
9        for(int i=1;i<m;i++){// loop m-1 times chalega
10          if(i%2==1){
11            for(int j=1;j<n;j++){
12            dp[1][j] = dp[1][j-1] + dp[0][j]; 
13           }
14          }
15          else{
16            for(int j=1;j<n;j++){
17            dp[0][j] = dp[0][j-1] + dp[1][j]; 
18           }
19          }
20        } 
21        return Math.max(dp[1][n-1],dp[0][n-1]);
22    }
23} 
24// space optimization 
25// class Solution {
26//     public int uniquePaths(int m, int n) {
27//         int[][]dp = new int[2][n]; // 2Xn ka dp array bnaya
28//         for(int j=0;j<n;j++){  // ab isme hr jagah 1 daal diya
29//             dp[0][j] = 1;
30//             dp[1][j] = 1; 
31//         }
32//         for(int i=1;i<m;i++){// loop m-1 times chalega
33//           for(int j=1;j<n;j++){
34//             dp[1][j] = dp[1][j-1] + dp[0][j]; // first dp wala kaam hoga
35//             dp[0][j] = dp[1][j]; // ab neeche wale row lo upar copy paste krdo
36//            }
37//         } 
38//         return dp[1][n-1];
39//     }
40// }    
41
42// class Solution {
43//     public int uniquePaths(int m, int n) {
44//         // now by tabulation
45//         int[][]dp = new int[m][n];
46//         for(int i=0;i<m;i++){
47//             for(int j=0;j<n;j++){
48//                 if(i==0||j==0) dp[i][j] = 1;
49//                 else dp[i][j] = dp[i][j-1] + dp[i-1][j];
50//             }
51//         }
52//         return dp[m-1][n-1];
53
54
55//     //  int [][]dp = new int[m+1][n+1];
56//     // Arrays.fill(dp,-1); you cannot use this in 2d arrays
57//     //   for(int[]arr:dp){
58//     //     Arrays.fill(arr,-1);
59//     //   }
60//      // return paths(m,n,dp);
61//      //  return helper(0,0,m-1,n-1,dp); 
62//     }
63//     // memoization M-1
64//     // private int paths(int m,int n,int[][]dp){
65//     //     if(m==1||n==1) return 1;
66//     //     if(dp[m][n] != -1) return dp[m][n];
67//     //     return dp[m][n] = paths(m,n-1,dp) + paths(m-1,n,dp);
68//     // }
69
70//     // memoization M-2
71//     // private int helper(int cr,int cl,int lr, int lc,int[][]dp){ // cr = current row , cl = current column
72//     //     if(cr>lr||cl>lc) return 0; // lr = last row, lc = last column
73//     //     if(cr==lr && cl==lc) return 1;
74//     //       if(dp[cr][cl] != -1) return dp[cr][cl];
75//     //     return dp[cr][cl] = helper(cr+1, cl,lr,lc,dp) + helper(cr,cl+1,lr,lc,dp);
76//     // }
77// }