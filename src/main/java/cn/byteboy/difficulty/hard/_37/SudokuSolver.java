package cn.byteboy.difficulty.hard._37;

import cn.byteboy.core.Solution;

/**
 * @author hongshaochuan
 * @Date 2021/8/10
 *
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 *  数独的解法需 遵循如下规则：
 *
 *
 *  数字 1-9 在每一行只能出现一次。
 *  数字 1-9 在每一列只能出现一次。
 *  数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 *
 *  数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 *
 *
 *
 *
 *
 *  示例：
 *
 *
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5","."
 * ,".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".","."
 * ,"3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"
 * ],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],["
 * .",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"
 * ],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["
 * 4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","
 * 6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","
 * 5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 *
 *
 *
 *
 *
 *
 *  提示：
 *
 *
 *  board.length == 9
 *  board[i].length == 9
 *  board[i][j] 是一位数字或者 '.'
 *  题目数据 保证 输入数独仅有一个解
 *
 *
 *
 *
 *  Related Topics 数组 回溯 矩阵
 *  👍 899 👎 0
 */
public class SudokuSolver {

    @Solution
    public void solveSudoku(char[][] board) {
        traverse(board, 0);
    }

    private boolean traverse(char[][] board, int index) {
        int len = board.length;
        if (index == len * len) {
            return true;
        }
        int j = index % len;
        int i = (index - j) /len;

        if (board[i][j] != '.') {
            return traverse(board, index + 1);
        }

        for (char k = '1'; k <= '9'; k++) {
            if (!isValid(board, i, j, k))
                continue;
            board[i][j] = k;
            if (traverse(board, index + 1)) {
                return true;
            }
            board[i][j] = '.';
        }

        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char v) {
        int len = board.length;
        // 横向
        for (int k = 0; k < len; k++) {
            if (board[i][k] == v) {
                return false;
            }
        }

        // 纵向
        for (int k = 0; k < len; k++) {
            if (board[k][j] == v) {
                return false;
            }
        }

        // 3x3
        int start_i = i / 3 * 3;
        int start_j = j / 3 * 3;
        for (int k = start_i; k < start_i + 3; k++) {
            for (int l = start_j; l < start_j + 3; l++) {
                if (board[k][l] == v) {
                    return false;
                }
            }
        }
        return true;
    }
}
