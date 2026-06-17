1class Solution {
2    public String reverseWords(String s) {
3        StringBuilder ans = new StringBuilder();
4        int i = s.length()-1;
5       
6        while(i>=0){
7            // remove trailing spaces
8            while(i>=0 && s.charAt(i) == ' '){
9                i--;
10            }
11            if(i<0) break;
12            int j = i;
13            while(j>= 0 && s.charAt(j) != ' '){
14                j--;
15            }
16            ans.append(s.substring(j+1,i+1));
17            
18            // remove faltu ke space where j is standing
19            while(j>=0 && s.charAt(j)==' '){
20                j--; // isse eextra space wale cases ignore ho jayenge
21            }
22            //if(j<0) first word pe tha mai so no space needed
23            if(j>=0) {
24                ans.append(" "); // space needed
25            }
26            i=j;
27        }
28        return ans.toString();
29        
30    }
31}