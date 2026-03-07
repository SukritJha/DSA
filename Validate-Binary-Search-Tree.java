1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public boolean isValidBST(TreeNode root) {
18        ArrayList<Integer> list = new ArrayList<>();
19        dfs(root,list);
20        for(int i=1;i<list.size();i++){
21            if(list.get(i) <= list.get(i-1)) return false;
22        }
23        return true;   
24    }
25    private void dfs(TreeNode root,ArrayList<Integer>list){
26        if(root == null) return;
27        dfs(root.left,list);
28        list.add(root.val);
29        dfs(root.right,list);
30    }
31}
32class twin{
33        int max;
34        int min;
35        twin(int max,int min){
36            this.max = max;
37            this.min = min;
38        }
39    }
40 // M-2 vvi
41// class Solution {
42//     boolean flag;
43//     public boolean isBST(Node root) {
44//         flag = true;
45//         maxmin(root);
46//         return flag;
47//     }
48//     private twin maxmin(Node root){
49//         if(root == null) return new twin(Integer.MIN_VALUE,Integer.MAX_VALUE);
50//         twin left = maxmin(root.left);
51//         twin right = maxmin(root.right);
52//         int max = Math.max(root.data,Math.max(left.max, right.max));
53//         int min = Math.min(root.data, Math.min(left.min,right.min));
54//         if(root.data<=left.max) flag = false;
55//         if(root.data>=right.min) flag = false;
56//         return new twin(max,min);
57//     }
58// }
59
60//M-3 vvi
61// class Solution {
62
63//     public boolean isValidBST(TreeNode root) {
64//         return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
65//     }
66
67//     private boolean check(TreeNode root, long min, long max){
68
69//         if(root == null) return true;
70
71//         if(root.val <= min || root.val >= max)
72//             return false;
73
74//         return check(root.left, min, root.val) &&
75//                check(root.right, root.val, max);
76//     }
77// }