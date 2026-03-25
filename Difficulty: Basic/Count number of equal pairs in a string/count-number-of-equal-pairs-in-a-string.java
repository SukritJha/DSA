// User function Template for Java

class Sol {
    long equalPairs(String s) {
        // your code here
        HashMap<Character,Integer>map = new HashMap<>();
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            long ans =0;
            for(char ele : map.keySet()){
                int freq = map.get(ele);
                ans +=  freq*freq;
            }
            return ans;
        
    }
}