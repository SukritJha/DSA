// User function Template for Java
class Solution {
    int countPairs(int[] arr, int k) {
       HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr) {
            if(map.containsKey(i)){
                int freq = map.get(i);
                map.put(i,freq+1);
            }
            else map.put(i,1);
        }
        int ans = 0;
        for(int ele : map.keySet()){
            int rem1 = ele + k;
            int rem2 = ele - k; 
            if(map.containsKey(rem1)){
                ans += (map.get(ele))*( map.get(rem1));
            }
            if(map.containsKey(rem2)){
                ans += (map.get(ele))*( map.get(rem2));
            }
        }
        ans = ans/2; // repeat hua hai kyuki 

        return ans;
    }
}