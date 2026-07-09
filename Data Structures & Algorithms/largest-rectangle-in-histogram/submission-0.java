class Solution {
    public int largestRectangleArea(int[] heights)
     {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++)
         {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) 
            {
                int h = heights[st.pop()];
                int l = st.isEmpty() ? -1 : st.peek();
                int w = i - l - 1;
                max = Math.max(max, h * w);
            }
            st.push(i);
        }
        while (!st.isEmpty())
         {
            int h = heights[st.pop()];
            int l = st.isEmpty() ? -1 : st.peek();
            int w = n - l - 1;
            max = Math.max(max, h * w);
        }
        return max;
    }
}