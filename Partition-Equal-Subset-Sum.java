1class Solution { // best soln
2    public boolean canPartition(int[] nums) {
3        int sum = 0;
4        
5        for (int num : nums) sum += num;
6
7        if (sum % 2 != 0) return false;
8
9        int target = sum / 2;
10
11        boolean[] dp = new boolean[target + 1];
12        dp[0] = true;
13
14        for (int num : nums) {
15            for (int j = target; j >= num; j--) {
16                dp[j] = dp[j] || dp[j - num];
17            }
18        }
19
20        return dp[target];
21    }
22}
23
24// class Solution { // by tabulation
25//     public boolean canPartition(int[] nums) {
26//         int sum =0; // sum of all elements of num
27//         int n = nums.length;
28//         for(int ele : nums) sum += ele;
29//         if(sum%2!=0) return false; // kyuki agar total sum odd hai toh uske break kr he nhi skte 2 subsets mein
30//         int target = sum/2; // target sum/2 isiliye liya kyuki hame 2 equal sum wale subsets lena hai
31//         int dp[][] = new int[n][target + 1];
32//         for(int i=0;i<dp.length;i++){
33//             for(int j=0;j<dp[0].length;j++){
34//                boolean ans = false;
35//                boolean skip = (i>0) ? (dp[i-1][j]==1) : (j==0); // ye ternary samjho j = target hai woh 0 hua toh true nhi toh false aur dp wala toh 1 pe true nhi toh false i>1 taki i-1 
36//                if(nums[i]>j) ans = skip;
37//                else{
38//                 boolean pick = (i>0) ? (dp[i-1][j-nums[i]]==1) : (j==0); // target 0 bnna zaruri hai na
39//                 ans = pick || skip;
40//                }
41//                dp[i][j] = (ans) ? 1 : 0;
42//             }
43//         }
44//         if(dp[n-1][target]==1) return true;
45//         else return false;
46//     }
47   
48// }
49
50// class Solution {
51//     public boolean canPartition(int[] nums) {
52//         int sum =0; // sum of all elements of num
53//         int n = nums.length;
54//         for(int ele : nums) sum += ele;
55//         int target = sum/2; // target sum/2 isiliye liya kyuki hame 2 equal sum wale subsets lena hai
56//         int dp[][] = new int[n][target + 1];
57//         for(int[]arr:dp) Arrays.fill(arr,-1);
58//         if(sum%2!=0) return false; // kyuki agar total sum odd hai toh uske break kr he nhi skte 2 subsets mein
59//         else return helper(0,nums,target,dp);
60//     }
61//     private boolean helper(int i,int[]nums,int target,int[][]dp){
62//         if(target == 0) return true;
63//         if(i == nums.length) return false;
64//         if(dp[i][target]!=-1) return (dp[i][target]==1);
65//         boolean ans = false;
66//         boolean skip = helper(i+1,nums,target,dp);
67//         if(nums[i]>target) ans = skip;
68//         else{
69//              boolean take = helper(i+1,nums,target-nums[i],dp);
70//              ans = skip || take;
71//         } 
72//         dp[i][target] = (ans) ? 1:0;
73//         return ans;
74//     }
75// }