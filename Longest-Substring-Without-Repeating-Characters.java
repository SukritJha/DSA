1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        // HashSet<Character>set = new HashSet<>();
4        // int i=0,j=0,maxlen = 0;
5        // while(j<s.length()){
6        //     char ch = s.charAt(j);
7        //     if(!set.contains(ch)){
8        //         set.add(ch);
9        //         j++;
10        //     }
11        //     else{
12        //         int len = j-i;
13        //         maxlen = Math.max(len,maxlen);
14        //         while(s.charAt(i) != s.charAt(j)){
15        //             set.remove(s.charAt(i));
16        //             i++;
17        //         }
18        //         i++;
19        //         j++;
20        //     }
21        // }
22        // int len = j-i;
23        // maxlen = Math.max(len,maxlen);
24        // return maxlen;
25
26
27        // M-2
28        //  HashMap<Character, Integer> map = new HashMap<>();
29        // int i = 0;        // start of window
30        // int maxlen = 0;   // answer
31        // // j is the end of window
32        // for (int j = 0; j < s.length(); j++) {
33
34        //     char ch = s.charAt(j);
35
36        //     // If character is already seen inside current window
37        //     if (map.containsKey(ch)) {
38
39        //         // Move start to avoid duplicate
40        //         // IMPORTANT: use Math.max to avoid going backward
41        //         i = Math.max(i, map.get(ch) + 1);
42        //     }
43
44        //     // Update latest index of character
45        //     //Math.max → prevents backward movement
46        //     //j-i+1 → inclusive window length
47        //      map.put(ch, j);
48
49        //     // Update max length of valid window
50        //     int len = j - i +1 ;
51        //     maxlen = Math.max(maxlen, len);
52        // }
53        // return maxlen;
54
55
56        // M-3
57        int[] freq = new int[256]; // this includes all possible characters which can be used in string
58        Arrays.fill(freq,-1); // initialize all characters with -1 means not visited
59        int i=0 , maxlen=0;
60        for(int j=0;j<s.length();j++){
61            char ch = s.charAt(j);
62            if(freq[ch] >= i){
63                i = freq[ch] + 1;
64            }
65            freq[ch] = j;
66            int len = j-i+1;
67            maxlen = Math.max(len,maxlen);
68        }
69        return maxlen;
70    }
71}