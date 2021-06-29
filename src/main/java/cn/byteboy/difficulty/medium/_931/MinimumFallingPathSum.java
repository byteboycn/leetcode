package cn.byteboy.difficulty.medium._931;

import cn.byteboy.core.Solution;

import java.util.Arrays;

/**
 * @author hongshaochuan
 * @date 2021/6/29
 *
 * url: https://leetcode-cn.com/problems/minimum-falling-path-sum/
 *
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 *
 *  下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
 * 一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
 * , col + 1) 。
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：下面是两条和最小的下降路径，用加粗标注：
 * [[2,1,3],      [[2,1,3],
 *  [6,5,4],       [6,5,4],
 *  [7,8,9]]       [7,8,9]]
 *
 *
 *  示例 2：
 *
 *
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：下面是一条和最小的下降路径，用加粗标注：
 * [[-19,57],
 *  [-40,-5]]
 *
 *
 *  示例 3：
 *
 *
 * 输入：matrix = [[-48]]
 * 输出：-48
 *
 *
 *
 *
 *  提示：
 *
 *
 *  n == matrix.length
 *  n == matrix[i].length
 *  1 <= n <= 100
 *  -100 <= matrix[i][j] <= 100
 *
 *  Related Topics 数组 动态规划 矩阵
 *  👍 96 👎 0
 */
public class MinimumFallingPathSum {

    int[][] memo;

    @Solution
    public int minFallingPathSum(int[][] matrix) {

        memo = new int[matrix.length][matrix.length];
        for (int[] ints : memo) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        int res = Integer.MAX_VALUE;
        int lastLineIndex = matrix.length - 1;
        for (int i = 0; i < matrix[lastLineIndex].length; i++) {
            res = Math.min(res, dp(matrix, lastLineIndex, i));
        }
        return res;
    }

    // dp表示从第0行某个位置到达x,y的最小路径和为 dp[matrix, x, y]
    private int dp(int[][] matrix, int x, int y) {
        // 边界检查
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[x].length) {
            // 返回Integer.MAX_VALUE会导致累加过程中数据溢出，所以只返回一个较大的值即可
            return Integer.MAX_VALUE / 2;
        }
        if (memo[x][y] != Integer.MAX_VALUE) {
            return memo[x][y];
        }

        if (x == 0) {
            return matrix[x][y];
        }
        memo[x][y] = matrix[x][y] + min(
                dp(matrix, x - 1, y),
                dp(matrix, x - 1, y - 1),
                dp(matrix, x - 1, y + 1)
        );
        return memo[x][y];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
