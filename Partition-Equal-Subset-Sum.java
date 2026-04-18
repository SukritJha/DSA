1class Solution {
2    public boolean canPartition(int[] nums) {
3        int sum =0; // sum of all elements of num
4        int n = nums.length;
5        for(int ele : nums) sum += ele;
6        int target = sum/2;
7        int dp[][] = new int[n][target + 1];
8        for(int[]arr:dp) Arrays.fill(arr,-1);
9        if(sum%2!=0) return false; // kyuki agar total sum odd hai toh uske break kr he nhi skte 2 subsets mein
10        else return helper(0,nums,target,dp);
11    }
12    private boolean helper(int i,int[]nums,int target,int[][]dp){
13        if(target == 0) return true;
14        if(i == nums.length) return false;
15        if(dp[i][target]!=-1) return (dp[i][target]==1);
16        boolean ans = false;
17        boolean skip = helper(i+1,nums,target,dp);
18        if(nums[i]>target) ans = skip;
19        else{
20             boolean take = helper(i+1,nums,target-nums[i],dp);
21             ans = skip || take;
22        } 
23        dp[i][target] = (ans) ? 1:0;
24        return ans;
25    }
26}