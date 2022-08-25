package com.cs.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumProduct {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1,2,3,4,5}));
    }

    private static int maxProduct(int[] nums) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            q.add(num);
        }
        int max=q.poll();
        int second=q.peek();
        return (max-1)*(second-1);
    }
}
