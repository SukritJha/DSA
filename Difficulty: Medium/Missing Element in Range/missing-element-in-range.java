class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
      
      //  Set<Integer>set = new HashSet<>();
       
    //     for(int i=low;i<=high;i++){
    //         set.add(i);
    //     }
    //     for(int element : arr){
    //         if(element>=low && element<=high){
    //             set.remove(element);
    //         }
    //     }
    //       ArrayList<Integer>list = new ArrayList<>(set);
    //       Collections.sort(list);
    //      return list;
    // 
         ArrayList<Integer>list = new ArrayList<>();
        //  for(int element:arr){
        //      set.add(element);
        //  }
        //  for(int i=low;i<=high;i++){
        //      if(!set.contains(i))  list.add(i);
        //  }
        //  return list;
        
        //M3
        boolean[] a = new boolean[high-low+1];
        for(int element : arr){
            if(element>=low && element<=high) a[element-low] = true;
        }
        for(int i=low;i<=high;i++){
            if(!a[i-low]) list.add(i);
        }
        return list;
    }
    
}