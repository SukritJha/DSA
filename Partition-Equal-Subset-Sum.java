1class Solution {
2    public boolean canPartition(int[] nums) {
3        int sum = 0;
4
5        // Find total sum of array
6        for (int num : nums) {
7            sum += num;
8        }
9
10        // If total sum is odd, equal partition is impossible
11        if (sum % 2 != 0) return false;
12
13        // We only need to find one subset with sum = totalSum / 2
14        int target = sum / 2;
15
16        // dp[j] means:
17        // Can we make sum = j using elements seen so far?
18        boolean[] dp = new boolean[target + 1];
19
20        // Sum 0 is always possible by taking no elements
21        dp[0] = true;
22
23        // Process every number one by one
24        for (int num : nums) {
25
26            // Traverse backwards so that same element is not reused
27            // If we go forward, current number may get used multiple times
28            for (int j = target; j >= num; j--) {
29
30                // Two choices:
31                // 1. Don't take current number -> dp[j] remains as it is
32                // 2. Take current number -> check if remaining sum was possible earlier
33                dp[j] = dp[j] || dp[j - num];
34            }
35        }
36
37        // If target sum is possible, equal partition is possible
38        return dp[target];
39    }
40}
41
42// class Solution { // by tabulation
43//     public boolean canPartition(int[] nums) {
44//         int sum =0; // sum of all elements of num
45//         int n = nums.length;
46//         for(int ele : nums) sum += ele;
47//         if(sum%2!=0) return false; // kyuki agar total sum odd hai toh uske break kr he nhi skte 2 subsets mein
48//         int target = sum/2; // target sum/2 isiliye liya kyuki hame 2 equal sum wale subsets lena hai
49//         int dp[][] = new int[n][target + 1];
50//         for(int i=0;i<dp.length;i++){
51//             for(int j=0;j<dp[0].length;j++){
52//                boolean ans = false;
53//                boolean skip = (i>0) ? (dp[i-1][j]==1) : (j==0); // ye ternary samjho j = target hai woh 0 hua toh true nhi toh false aur dp wala toh 1 pe true nhi toh false i>1 taki i-1 
54//                if(nums[i]>j) ans = skip;
55//                else{
56//                 boolean pick = (i>0) ? (dp[i-1][j-nums[i]]==1) : (j==0); // target 0 bnna zaruri hai na
57//                 ans = pick || skip;
58//                }
59//                dp[i][j] = (ans) ? 1 : 0;
60//             }
61//         }
62//         if(dp[n-1][target]==1) return true;
63//         else return false;
64//     }
65   
66// }
67
68// class Solution {
69//     public boolean canPartition(int[] nums) {
70//         int sum =0; // sum of all elements of num
71//         int n = nums.length;
72//         for(int ele : nums) sum += ele;
73//         int target = sum/2; // target sum/2 isiliye liya kyuki hame 2 equal sum wale subsets lena hai
74//         int dp[][] = new int[n][target + 1];
75//         for(int[]arr:dp) Arrays.fill(arr,-1);
76//         if(sum%2!=0) return false; // kyuki agar total sum odd hai toh uske break kr he nhi skte 2 subsets mein
77//         else return helper(0,nums,target,dp);
78//     }
79//     private boolean helper(int i,int[]nums,int target,int[][]dp){
80//         if(target == 0) return true;
81//         if(i == nums.length) return false;
82//         if(dp[i][target]!=-1) return (dp[i][target]==1);
83//         boolean ans = false;
84//         boolean skip = helper(i+1,nums,target,dp);
85//         if(nums[i]>target) ans = skip;
86//         else{
87//              boolean take = helper(i+1,nums,target-nums[i],dp);
88//              ans = skip || take;
89//         } 
90//         dp[i][target] = (ans) ? 1:0;
91//         return ans;
92//     }
93// }