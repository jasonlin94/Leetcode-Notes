// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Kth Smallest Element in a Sorted Matrix
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
// 

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] toX = {0, 1};
        int[] toY = {1, 0};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] hash = new boolean[n][m];
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new PairComparator());
        pq.add(new Pair(0, 0, matrix[0][0]));
        hash[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Pair current = pq.poll();
            for (int j = 0; j < 2; j++) {
                int nextX = current.x + toX[j];
                int nextY = current.y + toY[j];
                if (nextX < n && nextY < m && !hash[nextX][nextY]) {
                    hash[nextX][nextY] = true;
                    pq.add(new Pair(nextX, nextY, matrix[nextX][nextY]));
                }
            }
        }
        return pq.peek().val;
    }
}
class Pair {
    public int x, y, val;
    public Pair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class PairComparator implements Comparator<Pair> { // Comparator 还是abstract的 要加类型
    public int compare (Pair a, Pair b) {
        return a.val - b.val;
    }
}

