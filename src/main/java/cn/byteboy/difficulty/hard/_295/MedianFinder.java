package cn.byteboy.difficulty.hard._295;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hongshaochuan
 * @date 2021/7/31
 */
public class MedianFinder {

    private PriorityQueue<Integer> small;

    private PriorityQueue<Integer> large;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>((o1, o2) -> o2 - o1);
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (large.size() < small.size())
            return small.peek();
        if (large.size() > small.size())
            return large.peek();
        return (large.peek() + small.peek()) / 2.0;
    }
}
