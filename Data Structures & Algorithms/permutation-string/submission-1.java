class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        int[] a = new int[26];
        int[] b = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;
            b[s2.charAt(i) - 'a']++;
        }

        if (same(a, b))
            return true;

        int l = 0;

        for (int r = s1.length(); r < s2.length(); r++) {

            b[s2.charAt(r) - 'a']++;
            b[s2.charAt(l) - 'a']--;
            l++;

            if (same(a, b))
                return true;
        }

        return false;
    }

    boolean same(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}