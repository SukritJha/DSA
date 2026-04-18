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


public class SubsetSum {
    // recursive
//    public static void main(String[] args) {
//        int[] arr = {8,6,2,4};
//        int targetSum = 10; // basically ye btana hai ki iss array ka ek subset array hai ya nhi jiska sum 10 aaye
//        System.out.println(subset(0,arr,targetSum));
//    }
//
//    private static boolean subset(int i, int[] arr, int targetSum) {
//        if(i==arr.length) {
//            if(targetSum==0) return true;
//            else return false;
//        }
//        boolean skip = subset(i+1,arr,targetSum);
//        if(arr[i]>targetSum) return skip;
//        boolean take = subset(i+1,arr,targetSum-arr[i]);
//        return take || skip; // it will work but its time complexity is O(2^n) which is very bad hence we use memoization
//     }
public static void main(String[] args) {
    int[] arr = {8,6,2,4};
    int targetSum = 14; // basically ye btana hai ki iss array ka ek subset array hai ya nhi jiska sum 10 aaye
    int n = arr.length;
    // n-> 0 to n-1 and targetSum -> targetSum to 0 as hum minus krte jayenge
    int[][] dp = new int[n][targetSum+1];
    for(int[]a:dp) Arrays.fill(a,-1);
    System.out.println(subset(0,arr,targetSum,dp));
}
 // ab java mein directly boolean ko int mein convert  nhi kr skte ye problem hai C++ mein kr skte hai
    private static boolean subset(int i, int[] arr, int targetSum,int[][]dp) {
        if(i>=arr.length) {
            if(targetSum==0) return true;
            else return false;
        }
        if(dp[i][targetSum]!=-1) return (dp[i][targetSum] == 1); // ye ek condition hai na 0 -> false and 1 --> true
        boolean skip = subset(i+1,arr,targetSum,dp);
        boolean ans = false; //  isko hmne isiliye bnaya hai kyuki hum boolean function mein int wala dp return nhi krenge
        if(arr[i]>targetSum) ans = skip;
        else{
            boolean take = subset(i+1,arr,targetSum-arr[i],dp);
            ans =  take || skip;
        }
        dp[i][targetSum] = (ans) ? 1 : 0;
        return ans;
    }
}
