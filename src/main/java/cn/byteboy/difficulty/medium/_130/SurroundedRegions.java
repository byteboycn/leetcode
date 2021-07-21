package cn.byteboy.difficulty.medium._130;

import cn.byteboy.core.Solution;

/**
 * @author hongshaochuan
 * @Date 2021/7/21
 */
public class SurroundedRegions {

    @Solution
    public void solve(char[][] board) {


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


