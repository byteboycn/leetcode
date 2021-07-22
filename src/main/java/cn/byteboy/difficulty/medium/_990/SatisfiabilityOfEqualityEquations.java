package cn.byteboy.difficulty.medium._990;

import cn.byteboy.core.Solution;

/**
 * @author hongshaochuan
 * @Date 2021/7/22
 *
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!
 * =b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 *  只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 *
 *
 *
 *
 *
 *
 *  示例 1：
 *
 *  输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 *
 *
 *  示例 2：
 *
 *  输入：["b==a","a==b"]
 * 输出：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 *
 *
 *  示例 3：
 *
 *  输入：["a==b","b==c","a==c"]
 * 输出：true
 *
 *
 *  示例 4：
 *
 *  输入：["a==b","b!=c","c==a"]
 * 输出：false
 *
 *
 *  示例 5：
 *
 *  输入：["c==c","b==d","x!=z"]
 * 输出：true
 *
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= equations.length <= 500
 *  equations[i].length == 4
 *  equations[i][0] 和 equations[i][3] 是小写字母
 *  equations[i][1] 要么是 '='，要么是 '!'
 *  equations[i][2] 是 '='
 *
 *  Related Topics 并查集 图 数组 字符串
 *  👍 184 👎 0
 */
public class SatisfiabilityOfEqualityEquations {

    @Solution
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                uf.union(s.charAt(0), s.charAt(3));
            }
        }

        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (uf.connected(s.charAt(0), s.charAt(3)))
                    return false;
            }
        }
        return true;
    }

    static class UF {

        private final int[] parent;

        public UF(int count) {
            this.parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            p = offset(p);
            q = offset(q);
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            parent[rootP] = rootQ;
        }

        public boolean connected(int p, int q) {
            p = offset(p);
            q = offset(q);
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        private int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }

        private int offset(int x) {
            return x - 'a';
        }
    }
}
