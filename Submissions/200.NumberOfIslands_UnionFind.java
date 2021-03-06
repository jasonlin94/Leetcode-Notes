class Solution {
    
    private int n;
    private int m;
    private int[] toX = {0, 0, -1, 1};
    private int[] toY = {1, -1, 0, 0};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        UnionFind u = new UnionFind(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                }
            }
        }
        u.setCount(count);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int x = i + toX[k];
                    int y = j + toY[k];
                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == '0') { // 没判断 grid[x][y] == 1
                        continue;
                    }
                    u.connect(to1D(i, j), to1D(x, y));
                }
            }
        }
        return u.getCount();
    }
    private int to1D(int x, int y) {
        return x * m + y; // 错：x * n + y
    }
}
class UnionFind {
    private int[] father;
    private int count;
    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
            count--;
        }
    }
    public void setCount(int c) {
        count = c;
    }
    public int getCount() {
        return count;
    }
}