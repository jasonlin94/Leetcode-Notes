// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Sqrt(x)
// https://leetcode.com/problems/sqrtx/
// 

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        // WA: 溢出了 int改成long
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) { // 开根向下取整 mid取floor
                start = mid;
            } else {
                end = mid;
            }
        }
        // 答案夹在start和end之间
        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
}
