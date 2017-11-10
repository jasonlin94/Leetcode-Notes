// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Course Schedule
// https://leetcode.com/problems/course-schedule/
// 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List[] neighbors = new ArrayList[numCourses]; // 存list的数组 每一个entry都是一个arraylist
        for (int i = 0; i < numCourses; i++) {
            neighbors[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0]; // 错：忘了加第一个index
            int v = prerequisites[i][1]; // u -> v, indegree of v
            indegrees[v] += 1;
            neighbors[u].add(v);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            count++;
            int n = neighbors[cur].size();
            for (int i = 0; i < n; i++) {
                int neighbor = (int) neighbors[cur].get(i);
                indegrees[neighbor] -= 1;
                if (indegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return count == numCourses;
    }
}

