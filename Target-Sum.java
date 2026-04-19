1// class Solution {
2//     public int findTargetSumWays(int[] nums, int target) { // without dp
3//         return ways(0,nums,target);
4//     }
5//     private int ways(int i,int[]nums,int target){
6//         if(i==nums.length){
7//             if(target==0) return 1; // gives number of ways
8//             else return 0;
9//         }
10//         int subtract = ways(i+1,nums,target+nums[i]);
11//         int add =      ways(i+1,nums,target-nums[i]);
12//         return  add + subtract;
13//     }
14// }
15
16
17
18class Solution {
19    static int sum;
20    public int findTargetSumWays(int[] nums, int target) {
21        int n = nums.length;
22        sum =0;
23        for(int ele:nums) sum+=ele;
24        int[][]dp = new int[n][(2*sum)+1];
25        for(int[]arr:dp) Arrays.fill(arr,-1);
26        return ways(0,nums,0,target,dp);
27    } // hmne result variable bnaya aur hmara goal hai ki usse target tk pahuchana is our goal
28    private int ways(int i,int[]nums,int result, int target,int[][]dp){
29        if(i==nums.length) {
30            if(result==target) return 1; // ye number of ways dega
31            else return 0;
32        }
33        if(dp[i][result+sum]!=-1) return dp[i][result+sum];
34        int subtract = ways(i+1,nums,result-nums[i],target,dp);
35        int add = ways(i+1,nums,result+nums[i],target,dp);
36        return dp[i][result+sum] = add + subtract;
37    }
38}