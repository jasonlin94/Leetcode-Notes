// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Valid Anagram
// https://leetcode.com/problems/valid-anagram/
// 

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]--;
            if (map[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}

