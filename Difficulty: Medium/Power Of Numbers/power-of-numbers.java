class Solution {
    public int reverseExponentiation(int n) {
        // code here
       if(n==10) return 10;
       return pow(n,n); // baki digits single digit hai constraint dekho
    }
    private int pow(int a,int b){
        if(b==0) return 1;
        int call = pow(a,b/2);
        if(b%2==0) return call*call;
        else return a*call*call;
    }
}
