package com.ly.leetcode.code.binarysearch;

/**
 * 35. 搜索插入位置
 * @url https://leetcode.cn/problems/search-insert-position/
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int L =0;
        int R = nums.length -1;
        while (L <= R ){
            int mid = (L+R) >>>1;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                L = mid + 1;
            }else{
                R = mid - 1;
            }

        }
        return L;

    }
}
