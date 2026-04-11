// User function Template for Java

class Solution {
    static int countDer(int n) {
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    private static int helper(int n, int[] dp){
        if(n==1) return 0;
        if(n==2) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = (n-1)*helper(n-1,dp) + (n-1)*helper(n-2,dp);
    }
}


LOGIC :-

🔍 Let’s Build the Logic (INTUITION)

Focus on one element, say element 1.

Step 1: Where can element 1 go?
It cannot go to position 1
So it has (n - 1) choices

👉 Suppose it goes to position k

Step 2: What happens to element at position k?

Now there are 2 cases:

🟢 Case 1: Swap happens (mutual exchange)
Element 1 → position k
Element k → position 1

👉 Now both are fixed (valid derangement condition satisfied)

Remaining elements: n - 2

👉 Ways:

D(n - 2)
🔵 Case 2: No swap (chain continues)
Element 1 → position k
Element k → NOT go to position 1

👉 So element k must go somewhere else

Now problem reduces to:

Derangement of remaining n-1 elements

👉 Ways:

D(n - 1)
✅ Combine both cases

For each of (n - 1) choices:

D(n) = (n - 1) × (D(n - 1) + D(n - 2))
