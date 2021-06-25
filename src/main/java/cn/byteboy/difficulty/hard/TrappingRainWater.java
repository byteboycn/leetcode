package cn.byteboy.difficulty.hard;

import cn.byteboy.core.Solution;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/2/14 1:32 下午
 *
 * @name
 * 接雨水
 *
 * @url
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @description
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @exmaple
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int res = new TrappingRainWater().trap3(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
//        int res = new TrappingRainWater().trap2(new int[]{2,0,2});
        System.out.println(res);
    }

    // 按列求法 时间：O(n²) 空间：O(1)
    @Solution
    public int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            // 每列可存的水 取决于两边最高列较矮的列
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    // 按列求法 时间：O(n) 空间 O(n)
    @Solution
    public int trap1(int[] height) {
        int ans = 0;
        // 保存每列的左右两边的最高列 (不包含自身)
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i =  height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                ans += min - height[i];
            }
        }
        return ans;
    }

    // 对trap1进一步优化 按列求法 时间：O(n) 空间 O(n)  省了部分空间
    @Solution
    public int trap2(int[] height) {
        int ans = 0;
        // 保存每列的左右两边的最高列 (不包含自身)
//        int[] max_left = new int[height.length];
        int max_left = 0;
        int[] max_right = new int[height.length];
//        for (int i = 1; i < height.length; i++) {
//            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
//        }
        for (int i =  height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length; i++) {
            // 从左往右遍历时，可以在遍历结果的同时就计算出，max_left的值
            max_left = Math.max(max_left, height[i - 1]);
            int min = Math.min(max_left, max_right[i]);
            if (min > height[i]) {
                ans += min - height[i];
            }
        }
        return ans;
    }

    // 对trap2进一步优化 双指针法 时间：O(n) 空间 O(1)
    // 从左往右可以节省 max_left[]的空间，那从右往左遍历就可以节省 max_right[]的空间
    // 只要能设法可以既从左往右，又可以从右往左，就可以省掉空间
    @Solution
    public int trap3(int[] height) {
        int ans = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                if (max_left > height[left]) {
                    ans += max_left - height[left];
                }
                left++;
            //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                if (max_right > height[right]) {
                    ans += max_right - height[right];
                }
                right--;
            }
        }
        return ans;
    }

}
