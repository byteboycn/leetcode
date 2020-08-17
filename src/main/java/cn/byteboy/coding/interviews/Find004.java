package cn.byteboy.coding.interviews;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 23:35
 *
 * @name 二维数组中的查找
 *
 * @url https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * @description
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @example
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 */

public class Find004 {

    /**
     * 可以先从右上角开始扫描 (也可选左下角)
     * 若比target大，则忽略那一列，扫描前一列
     * 若比target小，则忽略那一行，扫描下一行
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        if (matrix[0].length == 0)
            return false;
        // 从右上角开始扫描
        int x = matrix[0].length - 1;
        int y = 0;
        while (y < matrix.length && x >= 0) {
            if (matrix[y][x] > target) {
                x--;
            } else if (matrix[y][x] < target) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }
}
