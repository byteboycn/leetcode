package cn.byteboy.difficulty.hard._773;

import cn.byteboy.core.Solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author hongshaochuan
 * @Date 2021/8/12
 *
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 *
 *  一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 *
 *  最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 *
 *  给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 *
 *  示例：
 *
 *
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 *
 *
 *
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 *
 *
 *
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 *
 *
 *
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 *
 *
 *  提示：
 *
 *
 *  board 是一个如上所述的 2 x 3 的数组.
 *  board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 *
 *  Related Topics 广度优先搜索 数组 矩阵
 *  👍 227 👎 0
 */
public class SlidingPuzzle {

    @Solution
    public int slidingPuzzle(int[][] board) {
        int[][] neighbor = new int[][]{
                {1,3},
                {0,2,4},
                {1,5},
                {0,4},
                {3,5,1},
                {2,4}
        };
        char[] chars = new char[6];
        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                chars[index++] = (char) (board[i][j] + 48); // int to char
            }
        }
        String start = new String(chars);
        String end = "123450";
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        int step = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (end.equals(cur))
                    return step;
                int zero_i = findZero(cur);
                int[] n = neighbor[zero_i];
                for (int k : n) {
                    String next = swap(cur, zero_i, k);
                    if (visited.contains(next))
                        continue;
                    q.offer(next);
                    visited.add(next);
                }

            }
            step++;

        }

        return -1;
    }

    private int findZero(String s) {
        for (int i = 0; i < s.length(); i++) {
            if ('0' == s.charAt(i))
                return i;
        }
        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

}
