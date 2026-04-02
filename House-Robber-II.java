1class Solution {
2    public int rob(int[] nums) {
3        int n = nums.length;
4        if(n==1) return nums[0];
5        int[] dp1 = new int[n];
6        int[] dp2 = new int[n];
7        dp1[0] = nums[0];
8        dp1[1] = Math.max(nums[0] , nums[1]);
9        for(int i=2;i<n-1;i++){
10            dp1[i] = Math.max(nums[i] + dp1[i-2] , dp1[i-1]);
11        }
12        dp2[0] = 0; // as we are not considering 0th term
13        dp2[1] = nums[1];
14         for(int i=2;i<n;i++){
15            dp2[i] = Math.max(nums[i] + dp2[i-2] , dp2[i-1]);
16        }
17        return Math.max(dp1[n-2],dp2[n-1]);
18        
19    //  int n = nums.length;
20    //  if(n==1) return nums[0];
21    //  // case 1 exclude last 
22    //  int [] dp1 = new int[n];
23    //  Arrays.fill(dp1,-1);
24    //  int case1 = helper(nums,0,n-2,dp1);
25    //  // case 2 exclude 0th index
26    //  int [] dp2 = new int[n];
27    //  Arrays.fill(dp2,-1);
28    //  int case2 = helper(nums,1,n-1,dp2);
29    //  return Math.max(case1,case2);
30    }
31    // private int helper(int[]nums,int i, int end, int[]dp){
32    //     if(i>end) return 0;
33    //     if(dp[i] !=-1) return dp[i];
34    //     int take = nums[i] + helper(nums,i+2,end,dp); // ith term ki liya
35    //     int skip = helper(nums,i+1,end,dp); // mtlab ith term ko nhi liya
36    //     return dp[i] = Math.max(take,skip);
37    // }
38}