// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Longest Substring with At Most Two Distinct Characters
// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
// 

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> dict = new HashMap<>();
        int low = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            dict.put(c, i);
            if (dict.size() > 2) {
                low = Collections.min(dict.values());
                dict.remove(s.charAt(low));
                low++;
            }
            max = Math.max(max, i - low + 1);
        }
        return max;
    }
}
