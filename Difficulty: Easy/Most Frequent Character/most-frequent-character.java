class Solution {
    public char getMaxOccuringChar(String s) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
               int freq = map.get(ch);
               map.put(ch,freq+1); // for overwriting
            }
            else{
                map.put(ch,1); // pehli baar aa rha hai na kyuki
            }
        }
        int maxfreq = 0;
        for(char ch : map.keySet()){
            int freq = map.get(ch);
            if(freq>maxfreq) maxfreq = freq;
        }
        char ans = 'z';
        for(char ch : map.keySet()){
            int freq = map.get(ch);
            if(freq == maxfreq && ch<ans){
                ans = ch;
            }
        }
        return ans;
    }
}