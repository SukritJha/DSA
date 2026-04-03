1class Solution {
2    public int reverse(int x) {
3        int r =0;
4        while(x!=0){
5           if (r > Integer.MAX_VALUE / 10 || r < Integer.MIN_VALUE / 10) {
6                return 0;
7            }
8            r *=10;
9            r += (x%10);
10            x/=10;
11        }
12        return r;
13    }
14}