package com.ly.leetcode.code.binarysearch;

/**
 * 162. 寻找峰值
 * @url https://leetcode.cn/problems/find-peak-element/
 *
 */
public class FindPeakElement {
    /**
     * 解法1
     * 中点所在地方，可能是某座山的山峰，山的下坡处，山的上坡处，如果是山峰，最后会二分终止也会找到，关键是我们的二分方向，并不知道山峰在我们左边还是右边，想象爬山，如果你往下坡方向走，也许可能遇到新的山峰，但是也许是一个一直下降的坡，最后到边界。
     * 但是如果你往上坡方向走，就算最后一直上的边界，由于最边界是负无穷，所以就一定能找到山峰，总的一句话，往递增的方向上，二分，一定能找到，往递减的方向只是可能找到，也许没有。
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left)/2;
            // 判断是左侧还是右侧有峰值
            if (nums[mid] > nums[mid + 1] ) {
                right = mid;
            } else {
                left = mid +1;
            }

        }
        return left;
    }
}
