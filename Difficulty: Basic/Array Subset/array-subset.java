
class Solution {
    public boolean isSubset(int a[], int b[]) {
        // Your code here
      //  better method using 1 hashmap
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
        
        // M-2 ussing two HashMaps
        // HashMap<Integer,Integer>amap = new HashMap<>();
        // HashMap<Integer,Integer>bmap = new HashMap<>();
        // for(int ele:a){
        //     amap.put(ele,amap.getOrDefault(ele,0)+1);
        // }
        // for(int ele:b){
        //     bmap.put(ele,bmap.getOrDefault(ele,0)+1);
        // }
        // for(int ele:bmap.keySet()){
        //     if(!amap.containsKey(ele)) return false;
        //     int afreq = amap.get(ele);
        //     int bfreq = bmap.get(ele);
        //     if(afreq<bfreq) return false;
        // }
        // return true;
    }
}
