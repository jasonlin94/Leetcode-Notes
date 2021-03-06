// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Rotate Array
// https://leetcode.com/problems/rotate-array/
// 

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // 先处理 否则null pointer
        if (nums == null || nums.length == 0) {
            return;
        }
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }
    private void swap(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

