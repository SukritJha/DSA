class Solution {
    public char getMaxOccuringChar(String s) {
        // code here
         int[]arr = new int[26];
         for(int i=0;i<s.length();i++){
             char curr = s.charAt(i); // iss curr ki ek ascii value hogi
             arr[curr-'a']++; // ye step yaad rkhna hr array aur character wale problem mein ata hai
         }
         int maxfreq = -1;
         char ans = s.charAt(0);
         for(int i=0;i<arr.length;i++){
             if(arr[i]>maxfreq){
                 maxfreq = arr[i];
                 ans = (char)(i +'a');// wapas character bnane ke liye fir se a ka ascii value add kra
         }
             }
              
         return ans;
    }
}