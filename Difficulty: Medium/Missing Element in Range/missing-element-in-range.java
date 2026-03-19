class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
      
        Set<Integer>set = new HashSet<>();
       // int [] nums = new int[arr[arr.length-1]];
        for(int i=low;i<=high;i++){
            set.add(i);
        }
        for(int element : arr){
            if(element>=low && element<=high){
                set.remove(element);
            }
        }
          ArrayList<Integer>list = new ArrayList<>(set);
          Collections.sort(list);
         return list;
    }
}