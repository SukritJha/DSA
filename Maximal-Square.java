1class Solution {
2    public int maximalSquare(char[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5        int[][] dp = new int[m][n];
6        int max = Integer.MIN_VALUE;
7        for(int i=0;i<m;i++){
8            for(int j=0;j<n;j++){
9                dp[i][j] = matrix[i][j] - '0';
10            }
11        }
12        for(int i=0;i<m;i++){
13            for(int j=0;j<n;j++){
14                if(i>0 && j>0 && dp[i][j]==1){
15                    dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i][j-1] , dp[i-1][j-1]));
16                }
17                max = Math.max(max,dp[i][j]);
18            }
19        }
20            return max*max;
21        
22    }
23}
24// ye tumne khud socha tha
25
26
27
28// aur ye better way tha 
29// class Solution {
30//     public int maximalSquare(char[][] matrix) {
31//         int m = matrix.length;
32//         int n = matrix[0].length;
33
34//         int[][] dp = new int[m][n];
35//         int max = 0;
36
37//         for(int i = 0; i < m; i++){
38//             for(int j = 0; j < n; j++){
39//                 if(matrix[i][j] == '1'){
40//                     if(i == 0 || j == 0){
41//                         dp[i][j] = 1;
42//                     }
43//                     else {
44//                         dp[i][j] = 1 + Math.min(dp[i-1][j],
45//                                    Math.min(dp[i][j-1], dp[i-1][j-1]));
46//                     }
47//                     max = Math.max(max, dp[i][j]);
48//                 }
49//             }
50//         }
51//         return max * max; // area
52//     }
53// }
54
55// Memoization way
56// class Solution {
57//     public int maximalSquare(char[][] matrix) {
58//         int m = matrix.length;
59//         int n = matrix[0].length;
60
61//         int[][] dp = new int[m][n];
62//         for (int[] row : dp) Arrays.fill(row, -1);
63
64//         int max = 0;
65
66//         // Try every cell as bottom-right of square
67//         for (int i = 0; i < m; i++) {
68//             for (int j = 0; j < n; j++) {
69//                 max = Math.max(max, helper(i, j, matrix, dp));
70//             }
71//         }
72
73//         return max * max;
74//     }
75
76//     private int helper(int i, int j, char[][] matrix, int[][] dp) {
77//         // Out of bounds
78//         if (i < 0 || j < 0) return 0;
79
80//         if (dp[i][j] != -1) return dp[i][j];
81
82//         if (matrix[i][j] == '0') return dp[i][j] = 0;
83
84//         int up = helper(i - 1, j, matrix, dp);
85//         int left = helper(i, j - 1, matrix, dp);
86//         int diag = helper(i - 1, j - 1, matrix, dp);
87
88//         return dp[i][j] = 1 + Math.min(up, Math.min(left, diag));
89//     }
90// }
91
92