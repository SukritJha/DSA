1class Solution {
2   // static int[] dp;
3    public int fib(int n) {
4        // if(n==0) return 0;
5        // if(n==1) return 1;
6        // if(n<=1) return n;
7        // return fib(n-1) + fib(n-2);
8
9        // better solution using dp
10       int[] memo = new int[n+1]; 
11       return helper(n,memo); // helper function
12    }
13    public int helper(int n , int[]memo){
14        if(n<=1) return n;
15        if(memo[n]!=0) return memo[n];
16        int ans = helper(n-1 , memo) + helper(n-2 , memo);
17        memo[n] = ans;
18        return ans;
19    }
20}