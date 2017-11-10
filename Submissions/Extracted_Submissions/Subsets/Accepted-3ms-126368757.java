// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Subsets
// https://leetcode.com/problems/subsets/
// 

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    private void helper(int[] nums,
                        int startIndex,
                        ArrayList<Integer> subset,
                        List<List<Integer>> results) {
        results.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, i + 1, subset, results); // startIndex + 1 -> i + 1
            subset.remove(subset.size() - 1);
        }
    }
    
}

