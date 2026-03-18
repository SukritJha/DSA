1class Solution {
2    public int sumOfUnique(int[] nums) {
3        // M1 - nested loop campare each element O(n^2) not very good space O(1)
4    // int sum = 0;
5    // for (int i = 0; i < nums.length; i++) {
6    //     int count = 0;
7
8    //     for (int j = 0; j < nums.length; j++) {
9    //         if (nums[i] == nums[j]) {
10    //             count++;
11    //         }
12    //     }
13    //     if (count == 1) {
14    //         sum += nums[i]; // unique elements when count is 1
15    //     }
16    // }
17    // return sum;
18
19       //M-2 HashMap (Most Common / Standard) O(n) space = O(n)
20        HashMap<Integer, Integer> map = new HashMap<>();
21
22    // for (int num : nums) {
23    //     map.put(num, map.getOrDefault(num, 0) + 1);
24    // }
25
26    // int sum = 0;
27
28    // for (int num : map.keySet()) {
29    //     if (map.get(num) == 1) {
30    //         sum += num;
31    //     }
32    // }
33    // return sum;
34
35    //M-3 Array Frequency O(n) space O(1)
36    int[] freq = new int[101]; // given constraint
37
38    for (int num : nums) {
39        freq[num]++; // uss number ki frequency hum badha denge jo jitni baar aa rha hoga
40    }
41
42    int sum = 0;
43
44    for (int i = 0; i < freq.length; i++) {
45        if (freq[i] == 1) {
46            sum += i;
47        }
48    }
49    return sum;
50        
51    }
52}