1class Solution {
2    public int rob(int[] nums) {
3        int []dp = new int[nums.length];
4        if(nums.length==1) return nums[0];
5        dp[0] = nums[0];
6        dp[1] = Math.max(nums[1],nums[0]);
7        for(int i=2;i<nums.length;i++){
8            dp[i] = Math.max(nums[i] + dp[i-2] , dp[i-1]);
9        }
10        return dp[nums.length-1];
11        // int n = nums.length;
12        // int []dp =  new int[n];
13        // Arrays.fill(dp,-1);
14        // return helper(nums,0,dp);
15    }
16    // private int helper(int[] nums,int idx, int[] dp){
17    //     if(idx>=nums.length) return 0;
18    //     if(dp[idx]!=-1) return dp[idx];
19    //     int take = nums[idx] + helper(nums,idx+2,dp);
20    //     int skip = helper(nums,idx+1,dp);
21    //     return dp[idx] = Math.max(take,skip);
22    // }
23}