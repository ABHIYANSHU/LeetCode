package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    /**
     * @author: @ABHIYANSHU
     * Time Complexity: O(26) + O(26) + O(n) + O(n) + O(26) = O(n)
     * Space Complexity: O(26) + O(26) = O(1)
     * Runtime: 3 ms, faster than 90.18% of Java online submissions for Valid Anagram.
     * Memory Usage: 44.24 MB, less than 70.29% of Java online submissions for Valid Anagram.
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
     * @author: @ABHIYANSHU
     * Time Complexity: O(n) + O(n) + O(n log n) + O(n log n) + O(n) = O(n log n)
     * Space Complexity: O(n) + O(n) = O(n)
     * Runtime: 3 ms, faster than 90.18% of Java online submissions for Valid Anagram.
     * Memory Usage: 46.45 MB, less than 18.93% of Java online submissions for Valid Anagram.
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

    /**
     * @author: @ABHIYANSHU
     * Time Complexity: O(n) + O(n) + O(n) = O(n)
     * Space Complexity: O(n) = O(n)
     * Runtime: 21 ms, faster than 09.86% of Java online submissions for Valid Anagram.
     * Memory Usage: 46.58 MB, less than 12.87% of Java online submissions for Valid Anagram.
     */
    public boolean isAnagramUsingHashMap(String s, String t) {
        HashMap<Integer, Integer> map = new HashMap<>();

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) { // O(n)
            int ascii = (char)(s.charAt(i));
            if (map.containsKey(ascii)) {
                map.put(ascii, map.get(ascii) + 1);
            } else {
                map.put(ascii, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) { // O(n)
            int ascii = (char)(t.charAt(i));
            if (map.containsKey(ascii)) {
                int val = map.get(ascii) - 1;
                if (val < 0)
                    return false;
                
                map.put(ascii, map.get(ascii) - 1);
            } else {
                return false;
            }
        }

        for (int i : map.keySet()) { // O(n)
            if (map.get(i) != 0)
                return false;
        }

        return true;
    }

    /**
     * @author: @LeetCode
     * Time Complexity: O(n) + O(n) = O(n)
     * Space Complexity: O(256) = O(1)
     * Runtime: 2 ms, faster than 98.86% of Java online submissions for Valid Anagram.
     * Memory Usage: 44.18 MB, less than 74.86% of Java online submissions for Valid Anagram.
     */
    public boolean isAnagramUsingArray(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] count = new int[256];

       for(char c:s.toCharArray()){ // O(n)
            count[c]++;
       }
       for(char c:t.toCharArray()){ // O(n)
            count[c]--;
       
       if(count[c] < 0)
            return false;
       } 

       return true;
    }
}