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
        char ans = s.charAt(0); 
        for(char ch : map.keySet()){
            int freq = map.get(ch);
            if(freq>maxfreq ||freq == maxfreq && ch<ans ){
                maxfreq = freq;
                ans = ch;
            } 
        }
        return ans;
    }
    // HashMap<Character, Integer> map = new HashMap<>();

    // for (char ch : s.toCharArray()) {
    //     map.put(ch, map.getOrDefault(ch, 0) + 1);
    // }

    // char ans = s.charAt(0);
    // int maxFreq = 0;

    // for (char ch : map.keySet()) {
    //     int freq = map.get(ch);

    //     if (freq > maxFreq || (freq == maxFreq && ch < ans)) {
    //         maxFreq = freq;
    //         ans = ch;
    //     }
    // }

    // return ans;

}