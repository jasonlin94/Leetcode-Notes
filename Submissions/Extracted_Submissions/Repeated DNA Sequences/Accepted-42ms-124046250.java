// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Repeated DNA Sequences
// https://leetcode.com/problems/repeated-dna-sequences/
// 



class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> once = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (once.contains(sub)) {
                repeated.add(sub);
            } else {
                once.add(sub);
            }
        }
        List<String> result = new ArrayList<>(repeated);
        return result;
    }
}

