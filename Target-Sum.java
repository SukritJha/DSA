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
14// }// recursive way not good
15
16// bhai iska dp bnane ka tarika is very very important so remember it
17class Solution {
18    static int sum;
19    public int findTargetSumWays(int[] nums, int target) {
20        int n = nums.length;
21        sum =0;
22        for(int ele:nums) sum+=ele;
23        int[][]dp = new int[n][2*sum+1];
24        for(int[]arr:dp) Arrays.fill(arr,-1);
25        return ways(0,nums,0,target,dp);
26    } // hmne result variable bnaya aur hmara goal hai ki usse target tk pahuchana is our goal
27    private int ways(int i,int[]nums,int result, int target,int[][]dp){
28        if(i==nums.length) {
29            if(result==target) return 1; // ye number of ways dega
30            else return 0;
31        }
32        if(dp[i][result+sum]!=-1) return dp[i][result+sum];
33        int subtract = ways(i+1,nums,result-nums[i],target,dp);
34        int add = ways(i+1,nums,result+nums[i],target,dp);
35        return dp[i][result+sum] = add + subtract;
36    }
37}