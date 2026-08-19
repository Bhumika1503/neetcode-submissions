class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        int[] p = new int[n];
        for (int i = 0; i < n; i++)
            p[i] = i;

        for (int[] e : edges) 
        {
            int a = find(p, e[0]);
            int b = find(p, e[1]);
            if (a == b)
                return false;
            p[a] = b;
        }
        return true;
    }

    private int find(int[] p, int x) {
        if (p[x] != x)
            p[x] = find(p, p[x]);
        return p[x];
    }
}
