
class Solution {
    public boolean isSubset(int a[], int b[]) {
        // Your code here
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int element : a){
          map.put(element,map.getOrDefault(element,0)+1);
        }
        for(int element : b){
            if(!map.containsKey(element)){
                return false;
            }
            if(map.get(element)==0) return false;
            if(map.containsKey(element)){
                map.put(element,map.get(element)-1);
            }
        }
        return true;
    }
}
