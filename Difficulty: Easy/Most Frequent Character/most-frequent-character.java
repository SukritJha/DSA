// class Solution {
//     public char getMaxOccuringChar(String s) {
//         // code here
//          int[]arr = new int[26];
//          for(int i=0;i<s.length();i++){
//              char curr = s.charAt(i); // iss curr ki ek ascii value hogi
//              arr[curr-'a']++; // ye step yaad rkhna hr array aur character wale problem mein ata hai
//          }
//          int maxfreq = -1;
//          char ans = s.charAt(0);
//          for(int i=0;i<arr.length;i++){
//              if(arr[i]>maxfreq){
//                  maxfreq = arr[i];
//                  ans = (char)(i +'a');// wapas character bnane ke liye fir se a ka ascii value add kra
//          }
//              }
              
//          return ans;
//     }
// }

// m2 ye lexographically nhi de payega as hashmap ka koi order nhi hota
class Solution {
    public char getMaxOccuringChar(String s) {
        // code here
         HashMap<Character,Integer>map = new HashMap<>();
         for(char ch : s.toCharArray()){
             map.put(ch,map.getOrDefault(ch,0)+1);
         }
         int maxfreq = -1;
         char ans = s.charAt(0);
         for(Character key : map.keySet()){
             if(map.get(key)>maxfreq){
                 maxfreq = map.get(key);
                 ans = key;// wapas character bnane ke liye fir se a ka ascii value add kra
            }
            else if(map.get(key)==maxfreq && key<ans){
                ans = key;
            }
                
          }
              
         return ans;
    }
}