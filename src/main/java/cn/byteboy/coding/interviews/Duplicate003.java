package cn.byteboy.coding.interviews;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 00:20
 *
 * @name 数组中重复的数字
 *
 * @url https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * @description
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * @example
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 */
public class Duplicate003 {


    /**
     * 长度为n，且范围为0～n-1，若不重复，则排好序后nums[i] == i，位置下标等于本身
     * 扫描数组，将nums[i]放到nums[nums[i]]，每个nums[i]仅需交换一次就能放到正确是位置，所以虽然用了两层循环但时间复杂度是O(n)
     *
     * @TimeComplexity O(n)
     * @SpaceComplexity O(1)
     */
    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;
        // 不能在下面的循环中调用，下面的循环会交换位置，无法正确遍历
        for (int num : nums) {
            // 无效测试用例
            if (num < 0 || num > length - 1) {
                return 0;
            }
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                // 当前扫描的数字在排好序的结构中已存在
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 交换nums[i]和nums[nums[i]]
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return 0;
    }

    /**
     * 若不改变原数组，则采用二分法查找
     * 长度为n+1，且范围为0～n-1，可这个数组分为两部分，前半部分0~m，后半部分m~n-1
     * 若0~m这几个数字在整个数组中出现的次数超过m+1，则一定是0~m中的几个数字中的某一个或多个重复了，后半部分同理
     * (排好序后nums[i] == i, 且多一个数据) 因此不能用findRepeatNumber的测试用例
     *
     * @TimeComplexity O(nlogn)
     * @SpaceComplexity O(1)
     */
    private int findRepeatNumberByNoSwap(int[] nums) {
        int length = nums.length;
        System.out.println(length);
        if (length <= 0)
            return 0;

        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int middle = ((end - start) >> 1) + start;

            int count = countRange(nums, start, middle);
            // 当start == end时，即一部分就一个元素时，不可再分
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            System.out.println(middle + ":" + count);
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return 0;
    }

    private int countRange(int[] nums, int start, int end) {
        int length = nums.length;
        if (length <= 0)
            return 0;
        int count = 0;
        for (int num : nums) {
            if (num >= start && num <= end)
                count++;
        }
        return count;
    }
}
