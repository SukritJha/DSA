class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        int [][]dp = new int[n][sum+1];
        for(int[]a:dp) Arrays.fill(a,-1);
        return helper(0,arr,sum,dp);
    }
    private static boolean helper(int i,int[]arr,int sum, int[][]dp){
        // base case
        if(i == arr.length) {
             if(sum==0) return true;
             else return false;
        }
       
        if(dp[i][sum] !=-1) return (dp[i][sum] == 1); // its a condition either true or false
        boolean ans = false;
        boolean skip = helper(i+1,arr,sum,dp);
        if(sum<arr[i]) ans = skip; // ye hum directly nhi likh skte in java thats why used ans
        else{
            boolean take = helper(i+1,arr,sum-arr[i],dp);
            ans = skip||take;
        }
        
        if(ans) dp[i][sum] = 1; // true
        else dp[i][sum] = 0; // false
        return ans;
    }
}