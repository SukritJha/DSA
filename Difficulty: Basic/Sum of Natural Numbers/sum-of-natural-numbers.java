class Solution {
    public static int findSum(int n) {
        // code here
        if(n==1) return 1;
        return n+findSum(n-1);
    }
}
