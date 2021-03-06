// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Search for a Range
// https://leetcode.com/problems/search-for-a-range/
// 

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] results = new int[2];
        int start = 0;
        int end = nums.length - 1;
        int mid;
        // left interval
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) { // 为什么是先看start
            results[0] = start;
        } else if (nums[end] == target) {
            results[0] = end;
        } else {
            return new int[]{-1, -1};
        }
        // right interval
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) { // 先看end
            results[1] = end;
        } else if (nums[start] == target) {
            results[1] = start;
        } else {
            return new int[]{-1, -1};
        }
        return results;
    }
}

