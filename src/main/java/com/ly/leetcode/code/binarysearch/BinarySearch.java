package com.ly.leetcode.code.binarysearch;

/**
 * 704. 二分查找
 * @url https://leetcode.cn/problems/binary-search/
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int L = 0, R = nums.length -1;
        int mid ;
        while (L <= R) {
            mid = L + (R - L)/2;
            if (nums[mid] > target) {
                R = mid - 1;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
