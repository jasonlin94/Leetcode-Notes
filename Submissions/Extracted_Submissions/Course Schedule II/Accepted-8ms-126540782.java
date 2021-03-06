// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Course Schedule II
// https://leetcode.com/problems/course-schedule-ii/
// 

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List[] neighbors = new ArrayList[numCourses];
        int[] results = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            neighbors[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int v = prerequisites[i][0];
            int u = prerequisites[i][1]; // u -> v
            neighbors[u].add(v);
            indegrees[v] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            results[index] = (int) cur;
            index++;
            int n = neighbors[cur].size();
            for (int i = 0; i < n; i++) {
                int neighbor = (int) neighbors[cur].get(i);
                indegrees[neighbor] -= 1;
                if (indegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (index == numCourses) {
            return results;
        }
        return new int[0];
    }
}

