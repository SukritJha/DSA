1class Solution {
2    public boolean isAnagram(String s, String t) {
3        // M-1 best method using array
4        // if(s.length() != t.length()) return false;
5        // int[] freq = new int[26]; // stores all alphabets frequency
6        // for(int i=0;i<s.length();i++){
7        //     freq[s.charAt(i) - 'a']++; // iska mtlab hai ki s ke saare chars ki frequency bdha denge
8        //     freq[t.charAt(i) - 'a']--; // isme hum t mein aane wale saare chars ki freq ghta denge
9        // }
10        // for(int ele : freq){
11        //     if(ele !=0) return false; // overall freq zero rehna chahiye agar nhi hai toh anagram nhi
12        // }
13        // return true;
14
15
16        // M-2 using HashMap
17        HashMap<Character,Integer>map = new HashMap<>();
18        if(s.length()!=t.length()) return false;
19        for(int i=0;i<s.length();i++){
20            char ch = s.charAt(i);
21            map.put(ch,map.getOrDefault(ch,0)+1);
22        }
23        for(int i=0;i<t.length();i++){
24            char tch = t.charAt(i);
25            if(!map.containsKey(tch)) return false;
26            if( map.get(tch)==0) return false;
27            if(map.containsKey(tch)){
28                map.put(tch,map.get(tch)-1);
29            }
30        }
31        return true;
32
33
34
35
36
37        // M-3 Two hashmaps method
38        // HashMap<Character,Integer>smap = new HashMap<>();
39        // HashMap<Character,Integer>tmap = new HashMap<>();
40        // if(s.length()!=t.length()) return false;
41        // for(int i=0;i<s.length();i++){
42        //     char ch = s.charAt(i);
43        //     smap.put(ch,smap.getOrDefault(ch,0)+1);
44        // }
45        // for(int i=0;i<t.length();i++){
46        //     char ch = t.charAt(i);
47        //     tmap.put(ch,tmap.getOrDefault(ch,0)+1);
48        // }
49        // for(char ele:tmap.keySet()){
50        //     if(!smap.containsKey(ele)) return false;
51        //     int sfreq = smap.get(ele);
52        //     int tfreq = tmap.get(ele);
53        //     if(sfreq!=tfreq) return false;
54        // }
55        // return true;
56    }
57}