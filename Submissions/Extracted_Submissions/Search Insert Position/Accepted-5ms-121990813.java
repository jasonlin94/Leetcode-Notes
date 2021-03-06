// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Search Insert Position
// https://leetcode.com/problems/search-insert-position/
// 

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] >= target) {
            return start;
        }
        if (target >= nums[start] && target <= nums[end]) {
            return end;
        }
        return end + 1;
        
    }
}

