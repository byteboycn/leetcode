package cn.byteboy.difficulty.medium._64;

import cn.byteboy.core.Solution;

import java.util.Arrays;

/**
 * @author hongshaochuan
 * @Date 2021/7/9
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 *  说明：每次只能向下或者向右移动一步。
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 *
 *  示例 2：
 *
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 *
 *
 *
 *  提示：
 *
 *
 *  m == grid.length
 *  n == grid[i].length
 *  1 <= m, n <= 200
 *  0 <= grid[i][j] <= 100
 *
 *  Related Topics 数组 动态规划 矩阵
 *  👍 923 👎 0
 */
public class MinimumPathSum {

    private int[][] memo;

    @Solution
    public int minPathSum(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dp(grid, grid.length - 1, grid[0].length - 1);
    }

    private int dp(int[][] grid, int x, int y) {
        if (x == 0 && y == 0)
            return grid[0][0];

        if (x < 0 || y < 0)
            return Integer.MAX_VALUE / 2;

        if (memo[x][y] != -1)
            return memo[x][y];

        memo[x][y] = Math.min(dp(grid, x - 1, y), dp(grid, x, y - 1)) + grid[x][y];

        return memo[x][y];
    }
}
