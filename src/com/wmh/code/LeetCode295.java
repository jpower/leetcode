package com.wmh.code;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 取中位數
 * Created by 周大侠
 * 2019-02-10 20:26
 */
public class LeetCode295 {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    /** initialize your data structure here. */
    public LeetCode295() {
        maxHeap = new PriorityQueue(50, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        minHeap = new PriorityQueue();
    }

    public void addNum(int num) {
        int maxSize = maxHeap.size();
        int minSize = minHeap.size();
        if(maxSize == minSize) {
            if(maxSize==0){
                maxHeap.add(num);
            }else if(num > maxHeap.peek()) {
                minHeap.add(num);
            }else{
                maxHeap.add(num);
            }
        }else if(maxSize > minSize) {
            if(num > maxHeap.peek()) {
                minHeap.add(num);
            }else{
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        }else{
            if(num > minHeap.peek()) {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }else {
                maxHeap.add(num);
            }
        }


    }

    public double findMedian() {
        int maxSize = maxHeap.size();
        int minSize = minHeap.size();
        if(maxSize == minSize) {
            if(maxSize==0){
                return 0;
            }
            return (maxHeap.peek()+minHeap.peek())/(double)2;
        }
        return maxSize > minSize ? maxHeap.peek() : minHeap.peek();

    }
}
