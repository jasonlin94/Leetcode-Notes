// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Find Median from Data Stream
// https://leetcode.com/problems/find-median-from-data-stream/
// 

class MedianFinder {

    /** initialize your data structure here. */
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(1000, Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.size() == 0) {
            maxHeap.offer(num);
            return;
        }
        if ((minHeap.size() + maxHeap.size()) % 2 == 0) {
            if (num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
                int right_min = (int) minHeap.poll();
                maxHeap.offer(right_min);
            }
        } else {
            if (num > maxHeap.peek()) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
                int left_max = (int) maxHeap.poll();
                minHeap.offer(left_max);
            }
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == 0) {
            return 0.0;
        }
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

