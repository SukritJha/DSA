1class Solution {
2    static int[] dp;
3    public int fib(int n) {
4        // if(n==0) return 0;
5        // if(n==1) return 1;
6        // if(n<=1) return n;
7        // return fib(n-1) + fib(n-2);
8
9        // better solution using dp
10       dp = new int[n+1]; 
11       return fibo(n); // helper function
12    }
13    public int fibo(int n){
14        if(n<=1) return n;
15        if(dp[n]!=0) return dp[n];
16        int ans = fibo(n-1) + fibo(n-2);
17        dp[n] = ans;
18        return ans;
19    }
20}