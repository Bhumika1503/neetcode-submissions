class Solution {

    public String encode(List<String> strs) {
        StringBuilder en = new StringBuilder();
        for(String w:strs)
        {
            en.append(w.length()).append("#").append(w);
        }
        return en.toString();


    }

    public List<String> decode(String w) {
        List <String> result= new ArrayList<>();
     
        int i=0;
        while(i<w.length())
        {
            int j=i;
            while(w.charAt(j)!='#')
            {
                j++;
            }
            int len=Integer.parseInt(w.substring(i,j));
            result.add(w.substring(j+1,j+1+len));
            i=j+1+len;
        }
        return result;
    }
}
