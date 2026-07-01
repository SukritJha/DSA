class Solution {
    public List<String> powerSet(String s) {
        // Code here
        List<String> ans = new ArrayList<>();
      
        StringBuilder output = new StringBuilder();
        int i=0;
        helper(s,output,i,ans);
        Collections.sort(ans);
        return ans;
    }
    private void helper(String s,StringBuilder o,int i, List<String>ans){
       
        if(i>=s.length()){
            String output = o.toString();
            ans.add(output);
            return;
        }
        char ch = s.charAt(i);
        o.append(ch); // include
        helper(s,o,i+1,ans);
        
        // exclude
        o.deleteCharAt(o.length()-1); // include wale char ko pehle remove krna hoga 
        helper(s,o,i+1,ans);// ab bus call maar do
        
        
        
    }
}

// class Solution {
//     public List<String> powerSet(String s) {
//         // Code here
//         List<String> ans = new ArrayList<>();
//       String  o = "";
//       //  StringBuilder output = new StringBuilder();
//         int i=0;
//         helper(s,o,i,ans);
//         Collections.sort(ans);
//         return ans;
//     }
//     private void helper(String s,String o,int i, List<String>ans){
       
//         if(i>=s.length()){
//             ans.add(o);
//             return;
//         }
//         char ch = s.charAt(i);
//       // o = o + s.charAt(i); // include
//         helper(s,o+ch,i+1,ans);
        
//         // exclude
//         helper(s,o,i+1,ans);// ab bus call maar do
        
        
        
//     }
// }