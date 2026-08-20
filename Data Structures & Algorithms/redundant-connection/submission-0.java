class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++)
            p[i] = i;
        for (int[] e : edges) {
            int a = find(p, e[0]);
            int b = find(p, e[1]);
            if (a == b)
                return e;
            p[a] = b;
        }

        return new int[0];
    }
    private int find(int[] p, int x) {
        if (p[x] != x)
            p[x] = find(p, p[x]);

        return p[x];
    }
}
