class Solution {
    public static int gcd(int a, int b) {
        // code here
        if(a==0) return b;
        return gcd(b%a,a);
        // int hcf=1;
        // for(int i=1;i<=Math.min(a,b);i++){
        //     if(a%i==0 && b%i==0) hcf =i;
        // }
        // return hcf;
        // but it will give TLE so recursion method is good
    }
}
