class Solution
 {
    public String minWindow(String s, String t)
     {
        int[] cnt = new int[128];
        for (char c : t.toCharArray()) cnt[c]++;

        int l = 0;
        int st= 0, len = Integer.MAX_VALUE, n = t.length();

        for (int r = 0; r < s.length(); r++)
         {
            if (cnt[s.charAt(r)]-- > 0) n--;

            while (n == 0)
             {
                if (r - l + 1 < len)
                 {
                    len = r - l + 1;
                    st = l;
                }

                if (++cnt[s.charAt(l++)] > 0)
                    n++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(st, st+ len);
    }
}