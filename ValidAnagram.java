package LeetCode;

import java.util.Arrays;

public class ValidAnagram {

    /**
     * Time Complexity: O(26) + O(26) + O(n) + O(n) + O(26) = O(n)
     * Space Complexity: O(26) + O(26) = O(1)
     * Runtime: 2 ms, faster than 98.99% of Java online submissions for Valid Anagram.
     * Memory Usage: 42.5 MB, less than 91.80% of Java online submissions for Valid Anagram.
     */
    public boolean isAnagramUsingTwoArrays(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        Arrays.fill(count1, 0); // O(26)
        Arrays.fill(count2, 0); // O(26)
         
        for (int i = 0; i < s.length(); i++) { // O(n)
            count1[(int)s.charAt(i) - 97]++;
        }
        for (int i = 0; i < t.length(); i++) { // O(n)
            count2[(int)t.charAt(i) - 97]++;
        }
        for (int i = 0; i < 26; i++) { // O(26)
            if (count1[i] != count2[i])
                return false;
        }
        
        return true;
    }

    /**
     * Time Complexity: O(n) + O(n) + O(n log n) + O(n log n) + O(n) = O(n log n)
     * Space Complexity: O(n) + O(n) = O(n)
     * Runtime: 4 ms, faster than 84.94% of Java online submissions for Valid Anagram.
     * Memory Usage: 45.5 MB, less than 29.99% of Java online submissions for Valid Anagram.
     */
    public boolean isAnagramUsingCharArray(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        char[] array1 = s.toCharArray(); // O(n)
        char[] array2 = t.toCharArray(); // O(n)
        
        Arrays.sort(array1); // O(n log n)
        Arrays.sort(array2); // O(n log n)
        
        for (int i = 0; i < array1.length; i++) { // O(n)
            if (array1[i] != array2[i])
                return false;
        }
        
        return true;
    }
}