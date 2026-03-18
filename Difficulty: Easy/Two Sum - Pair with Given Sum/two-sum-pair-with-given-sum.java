class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int i=0, j = n-1; // two pointer approach
        while(i<j){
            if(arr[i] + arr[j]<target) i++;
            else if(arr[i] + arr[j] > target) j--;
            else return true;
        }
        return false;
    }
}