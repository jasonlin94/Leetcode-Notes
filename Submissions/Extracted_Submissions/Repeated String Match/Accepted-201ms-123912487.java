// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Repeated String Match
// https://leetcode.com/problems/repeated-string-match/
// 

class Solution {
    public int repeatedStringMatch(String A, String B) {
        int times = 1;
        StringBuilder sb = new StringBuilder(A);
        while (sb.length() < B.length()) {
            sb.append(A);
            times++;
        }
        if (sb.indexOf(B) >= 0) {
            return times;
        } else {
            sb.append(A);
            times++;
            if (sb.indexOf(B) >= 0) {
                return times;
            }
        }
        return -1;
    }
    // private boolean checkSubstring(String a, String b) {
    //     for (int i = 0; i < b.length() - a.length() + 1; i++) {
    //         int a_cur = i;
    //         int b_cur;
    //         for (b_cur = 0; b_cur < b.length(); b_cur++) {
    //             if (a.charAt(a_cur) == b.charAt(b_cur)) {
    //                 a_cur++;
    //             } else {
    //                 break;
    //             }
    //         }
    //         if (b_cur == b.length()) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}

