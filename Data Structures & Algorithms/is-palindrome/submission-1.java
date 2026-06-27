 class Solution {
    public boolean isPalindrome(String s) {

        String st = "", rev = "";
        
         for (char c : s.toCharArray()) 
         {
            if (Character.isLetterOrDigit(c)) 
                st+= Character.toLowerCase(c);
         }

        for (int i = st.length()- 1; i >= 0; i--) 
            rev += st.charAt(i);

        return st.equals(rev);
    }
}
