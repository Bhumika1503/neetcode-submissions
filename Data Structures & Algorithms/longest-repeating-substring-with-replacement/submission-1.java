class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[50];
        int l = 0, maxFreq = 0, ans = 0;

        for (int r = 0; r < s.length(); r++) 
        {
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(r) - 'A']);
            while (r - l + 1 - maxFreq > k) 
            {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
         return ans;
    }
}