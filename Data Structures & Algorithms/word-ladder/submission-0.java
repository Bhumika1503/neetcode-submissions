class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) 
        return 0;
        Set<String> a = new HashSet<>();
        Set<String> b = new HashSet<>();
        a.add(beginWord);
        b.add(endWord);
        set.remove(beginWord);
        set.remove(endWord);
        int len = 1;
        while (!a.isEmpty() && !b.isEmpty())
         {
            if (a.size() > b.size()) 
            {
                Set<String> temp = a;
                a = b;
                b = temp;
            }

            Set<String> next = new HashSet<>();
            for (String s : a)
             {
                char[] ch = s.toCharArray();
                for (int i = 0; i < ch.length; i++)
                 {
                    char old = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) 
                    {
                        if (c == old) continue;
                        ch[i] = c;
                        String t = new String(ch);
                        if (b.contains(t)) return len + 1;
                        if (set.remove(t))
                            next.add(t);
                    }
                    ch[i] = old;
                }
            }
            a = next;
            len++;
        }
        return 0;
    }
}