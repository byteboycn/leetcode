package cn.byteboy.difficulty.medium._130;

import cn.byteboy.core.Solution;

/**
 * @author hongshaochuan
 * @Date 2021/7/21
 *
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
 * 。
 *
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X"
 * ,"X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
 * 会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 *
 *  示例 2：
 *
 *
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *
 *
 *
 *
 *  提示：
 *
 *
 *  m == board.length
 *  n == board[i].length
 *  1 <= m, n <= 200
 *  board[i][j] 为 'X' 或 'O'
 *
 *
 *
 *  Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵
 *  👍 569 👎 0
 */
public class SurroundedRegions {

    @Solution
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        UF uf = new UF(m * n + 1);
        int dummy = m * n;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                uf.union(i * n, dummy);
            if (board[i][n - 1] == 'O')
                uf.union(i * n + n - 1, dummy);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                uf.union(j, dummy);
            if (board[m - 1][j] == 'O')
                uf.union(n * (m - 1) + j, dummy);
        }

        int[][] d = new int[][]{{1,0}, {0,1}, {0,-1},{-1,0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O')
                            uf.union(x * n + y, i * n + j);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!uf.connected(dummy, i * n + j))
                    board[i][j] = 'X';
            }
        }

    }

    static class UF {
        private int count;

        private int[] parent;

        public UF(int count) {
            this.count = count;
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootQ = find(q);
            int rootP = find(p);
            if (rootP == rootQ)
                return;
            parent[rootP] = rootQ;
            count--;
        }

        public boolean connected(int p, int q) {
            int rootQ = find(q);
            int rootP = find(p);
            return rootP == rootQ;
        }

        public int count() {
            return count;
        }

        private int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }
    }
}


