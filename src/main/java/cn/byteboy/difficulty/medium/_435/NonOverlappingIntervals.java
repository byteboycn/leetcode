package cn.byteboy.difficulty.medium._435;

import cn.byteboy.core.Solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hongshaochuan
 * @date 2021/7/3
 *
 * url: https://leetcode-cn.com/problems/non-overlapping-intervals/
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 *  注意:
 *
 *
 *  可以认为区间的终点总是大于它的起点。
 *  区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 *
 *  示例 1:
 *
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 *
 *  示例 2:
 *
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 *
 *
 *  示例 3:
 *
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 *  Related Topics 贪心 数组 动态规划 排序
 *  👍 440 👎 0
 */
public class NonOverlappingIntervals {

    @Solution
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        // 不重叠区间数
        int res = 1;
        int value = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= value) {
                res++;
                value = intervals[i][1];
            }
        }

        return intervals.length - res;
    }
}
