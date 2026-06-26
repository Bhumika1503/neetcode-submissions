class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String w: strs)
        {
            char[] ch=w.toCharArray();
            Arrays.sort(ch);
            String key= new String(ch);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(w); 
                   }
                   return new ArrayList<>(map.values());
        }
}
