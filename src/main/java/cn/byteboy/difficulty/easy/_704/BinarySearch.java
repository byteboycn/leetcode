package cn.byteboy.difficulty.easy._704;

import cn.byteboy.core.Solution;

/**
 * @author hongshaochuan
 * @Date 2021/7/26
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
 * 则返回 -1。
 *
 *
 * 示例 1:
 *
 *  输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 *
 *  示例 2:
 *
 *  输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 *
 *
 *
 *  提示：
 *
 *
 *  你可以假设 nums 中的所有元素是不重复的。
 *  n 将在 [1, 10000]之间。
 *  nums 的每个元素都将在 [-9999, 9999]之间。
 *
 *  Related Topics 数组 二分查找
 *  👍 282 👎 0
 */
public class BinarySearch {

    @Solution
    public int search(int[] nums, int target) {

        return binary_search(nums, target);
    }

    public int binary_search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                right = mid - 1;
            else if (target > nums[mid])
                left = mid + 1;
        }
        return -1;
    }

    public int left_search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                right = mid - 1;
            else if (target < nums[mid])
                right = mid - 1;
            else if (target > nums[mid])
                left = mid + 1;
        }
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;

    }

    public int right_search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                left = mid + 1;
            else if (target > nums[mid])
                left = mid + 1;
            else if (target < nums[mid])
                right = mid - 1;
        }
        if (right < 0 || nums[right] != target)
            return -1;
        return right;

    }



    public static void main(String[] args) {
//        int[] nums = new int[]{ 1,2,2,3};
        int[] nums = new int[]{ 1,2,2,2,3 };
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binary_search(nums, 2));
        System.out.println(bs.left_search(nums, 2));
        System.out.println(bs.right_search(nums, 2));
    }


}
