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
13        if(i==nums.length){
14            if(target == 0) return true;
15            else return false;
16        }
17        if(dp[i][target]!=-1) return (dp[i][target]==1);
18        boolean ans = false;
19        boolean skip = helper(i+1,nums,target,dp);
20        if(nums[i]>target) ans = skip;
21        else{
22             boolean take = helper(i+1,nums,target-nums[i],dp);
23             ans = skip || take;
24        } 
25        dp[i][target] = (ans) ? 1:0;
26        return ans;
27    }
28}