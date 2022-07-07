package LeetCode;

public class ValidPalindrome {
    
    /**
     * Time Complexity: O(n) + O(n) = O(n)
     * Space Complexity: O(1)
     * Runtime: 6 ms, faster than 65.51% of Java online submissions for Valid Palindrome.
     * Memory Usage: 43.5 MB, less than 71.22% of Java online submissions for Valid Palindrome.
     */
    public boolean isPalindromeUsingTwoPointers(String s) {
        s = s.toLowerCase(); // O(n)
        int n = s.length() - 1;
        int i = 0;
        int j = n;
        
        while (i < j) { // O(n)
            char c1 = s.charAt(i); // O(1)
            char c2 = s.charAt(j); // O(1)
            
            boolean validC1 = Character.isLetter(c1) || Character.isDigit(c1); // can be replaced by Character.isLetterOrDigit(c1);
            boolean validC2 = Character.isLetter(c2) || Character.isDigit(c2); // can be replaced by Character.isLetterOrDigit(c2);
            if (validC1 && validC2) {
                if (c1 != c2)
                    return false;
                
                i++;
                j--;
            } else if (!validC1 && validC2) {
                i++;
            } else if (validC1 && !validC2) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        
        return true;
    }

    /**
     * Time Complexity: O(n) + O(n) + O(n) = O(n)
     * Space Complexity: O(n)
     * Runtime: 7 ms, faster than 57.37% of Java online submissions for Valid Palindrome.
     * Memory Usage: 44.3 MB, less than 41.46% of Java online submissions for Valid Palindrome.
     */
    public boolean isPalindromeUsingStringBuilder(String s) {
        
        StringBuilder modified = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) { // O(n)
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c))
                modified.append(c);
        }
        
        modified = new StringBuilder(modified.toString().toLowerCase()); // O(n)
        String value = modified.toString();
        return value.equals(modified.reverse().toString()); // O(n)
    }
}
