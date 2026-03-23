1class Solution {
2    public int findPairs(int[] nums, int k) {
3        if (k < 0) return 0;
4        HashMap<Integer,Integer> map = new HashMap<>();
5        for(int num : nums){
6            map.put(num, map.getOrDefault(num, 0) + 1);
7        }
8        int ans = 0;
9        if(k == 0){
10            for(int ele : map.keySet()){
11                if(map.get(ele) > 1){
12                    ans++;
13                }
14            }
15        } else {
16            for(int ele : map.keySet()){
17                if(map.containsKey(ele + k)){
18                    ans++;
19                }
20            }
21        }
22        return ans;
23    }
24}
25    