class Solution {

    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int c = 0; c < n; c++) 
        {
            dfs(heights, pacific, 0, c);
        }
        for (int r = 0; r < m; r++) 
        {
            dfs(heights, pacific, r, 0);
        }
        for (int c = 0; c < n; c++) 
        {
            dfs(heights, atlantic, m - 1, c);
        }

        for (int r = 0; r < m; r++) 
        {
            dfs(heights, atlantic, r, n - 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs( int[][] heights, boolean[][] visited, int r,int c) {
        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        for (int[] dir : directions)
         {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(heights, visited, nr, nc);
            }
        }
    }
}