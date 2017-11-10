// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Valid Palindrome II
// https://leetcode.com/problems/valid-palindrome-ii/
// 

class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean flag = false;
        int i = 0;
        int j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (i >= j) {
            return true;
        }
        return (validPali(s, i + 1, j) || validPali(s, i, j - 1));
        // while (i < j) {
        //     if (s.charAt(i) != s.charAt(j)) {
        //         if (flag == false) {
        //             if (i + 1 <= j && s.charAt(i + 1) == s.charAt(j)) {
        //                 i++;
        //                 flag = true;
        //                 continue;
        //             } else if (i <= j - 1 && s.charAt(i) == s.charAt(j - 1)) {
        //                 j--;
        //                 flag = true;
        //                 continue;
        //             } else {
        //                 return false;
        //             }
        //         } else {
        //             return false;
        //         }
        //     }
        //     i++;
        //     j--;
        // }
        // return true;
    }
    private boolean validPali(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

