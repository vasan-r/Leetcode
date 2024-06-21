class Solution {
    public String reverseWords(String s) {
        // Split the string by one or more spaces
        String[] str = s.trim().split("\\s+");
        
        // Use StringBuilder for efficient concatenation
        StringBuilder st = new StringBuilder();
        
        // Append words in reverse order
        for (int i = str.length - 1; i >= 0; i--) {
            st.append(str[i]);
            if (i > 0) {
                st.append(" ");
            }
        }
        
        return st.toString();
    }
}
