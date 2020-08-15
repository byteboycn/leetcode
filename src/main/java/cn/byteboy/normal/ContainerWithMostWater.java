package cn.byteboy.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/2/14 3:48 上午
 *
 * @name
 * 盛最多水的容器
 *
 * @url
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @description
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * @example
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.printf("value:" + new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        List<Integer> list = new ArrayList<>();
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i != j) {
            int w = j - i;
            int h = Math.min(height[i], height[j]);
            if (w * h > res) {
                res = w * h;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }


}


