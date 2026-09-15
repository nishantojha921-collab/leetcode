class Solution {

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        DisjointSet dsu = new DisjointSet(n);

        for (int[] edge : edges) {

            int u = edge[0] - 1;
            int v = edge[1] - 1;

            if (!dsu.unionBySize(u, v)) {
                return edge;
            }
        }

        return new int[0];
    }

    class DisjointSet {

        int[] parent;
        int[] size;

        DisjointSet(int n) {

            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {

            if (parent[x] == x) {
                return x;
            }

            // Path compression
            return parent[x] = find(parent[x]);
        }

        boolean unionBySize(int u, int v) {

            int pu = find(u);
            int pv = find(v);

            // Already connected -> cycle found
            if (pu == pv) {
                return false;
            }

            // Attach smaller set to larger set
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }

            return true;
        }
    }
}