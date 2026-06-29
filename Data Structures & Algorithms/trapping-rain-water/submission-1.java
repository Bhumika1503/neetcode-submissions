class Solution {
    public int trap(int[] h) {
        int l = 0, r = h.length - 1;
        int lm = 0, rm = 0, wat = 0;
        while (l < r) 
        {
            if (h[l] < h[r]) 
            {
                lm = Math.max(lm, h[l]);
                wat += lm - h[l];
                l++;
            } 
            else 
            {
                rm = Math.max(rm, h[r]);
                wat += rm - h[r];
                r--;
            } } 
        return wat;
    }}
