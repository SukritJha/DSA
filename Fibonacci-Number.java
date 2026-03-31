1class Solution {
2   // static int[] dp;
3    public int fib(int n) {
4        if(n<=1) return n;
5        int [] arr = new int[n+1];
6        arr[0] = 0;
7        arr[1] = 1;
8        for(int i =2;i<arr.length;i++){
9            arr[i] = arr[i-1] + arr[i-2];
10        }
11        return arr[arr.length-1];
12        // if(n==0) return 0;
13        // if(n==1) return 1;
14        // if(n<=1) return n;
15        // return fib(n-1) + fib(n-2);
16        // better solution using dp
17    //    int[] memo = new int[n+1]; 
18    //    return helper(n,memo); // helper function
19    }
20    // public int helper(int n , int[]memo){
21    //     if(n<=1) return n;
22    //     if(memo[n]!=0) return memo[n];
23    //     // int ans = helper(n-1 , memo) + helper(n-2 , memo);
24    //     // memo[n] = ans;
25    //     // return ans;
26    //     // you can short it also
27    //     return memo[n] = helper(n-1,memo) + helper(n-2,memo);
28    // }
29}