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
18        TreeNode curr =root;
19        Long prev =Long.MIN_VALUE;
20        while(curr!=null){
21            if(curr.left!=null){
22                TreeNode pred = curr.left;
23                while(pred.right!=null && pred.right!=curr){
24                    pred = pred.right;
25                }
26                if(pred.right==null){
27                    pred.right = curr;
28                    curr = curr.left;
29                }
30                else{
31                    pred.right = null;
32                    if(curr.val<=prev) return false;
33                    prev = (long)curr.val;
34                    curr = curr.right;
35                }
36            }
37            else{
38                if(curr.val<=prev) return false;
39                prev = (long)curr.val;
40                curr = curr.right;
41            }
42        }
43        return true;
44
45    }
46}
47
48
49    //     ArrayList<Integer> list = new ArrayList<>();
50    //     dfs(root,list);
51    //     for(int i=0;i<list.size()-1;i++){
52    //         if(list.get(i) >= list.get(i+1)) return false;
53    //     }
54    //     return true;   
55    // }
56    // private void dfs(TreeNode root,ArrayList<Integer>list){
57    //     if(root == null) return;
58    //     dfs(root.left,list);
59    //     list.add(root.val);
60    //     dfs(root.right,list);
61    // }
62
63
64 // M-2 vvi
65//  class twin{
66//         int max;
67//         int min;
68//         twin(int max,int min){
69//             this.max = max;
70//             this.min = min;
71//         }
72//     }
73// class Solution {
74//     boolean flag;
75//     public boolean isBST(Node root) {
76//         flag = true;
77//         maxmin(root);
78//         return flag;
79//     }
80//     private twin maxmin(Node root){
81//         if(root == null) return new twin(Integer.MIN_VALUE,Integer.MAX_VALUE);
82//         twin left = maxmin(root.left);
83//         twin right = maxmin(root.right);
84//         int max = Math.max(root.data,Math.max(left.max, right.max));
85//         int min = Math.min(root.data, Math.min(left.min,right.min));
86//         if(root.data<=left.max) flag = false;
87//         if(root.data>=right.min) flag = false;
88//         return new twin(max,min);
89//     }
90// }
91
92//M-3 vvi
93// class Solution {
94
95//     public boolean isValidBST(TreeNode root) {
96//         return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
97//     }
98
99//     private boolean check(TreeNode root, long min, long max){
100
101//         if(root == null) return true;
102
103//         if(root.val <= min || root.val >= max)
104//             return false;
105
106//         return check(root.left, min, root.val) &&
107//                check(root.right, root.val, max);
108//     }
109// }