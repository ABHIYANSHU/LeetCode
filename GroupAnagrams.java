import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    /**
     * @author: @LeetCode
     * Time Complexity: O(n * k), where n is the number of strings in strs, and k is the maximum length of a string in strs.
     * Space Complexity: O(n * k)
     * Runtime: 18 ms, faster than 25.69% of Java online submissions for Group Anagrams.
     * Memory Usage: 51.09 MB, less than 5.88% of Java online submissions for Group Anagrams.
     */
    public List<List<String>> groupAnagramsUsingHashMapAndPutIfAbsent(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) { // O(n)
            int[] count = new int[26];
            for (char c : s.toCharArray()) { // O(k)
                count[c - 'a']++;
            }

            String key = Arrays.toString(count); // O(1)
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values()); // O(n)
    }

    /**
     * @author: @LeetCode
     * Time Complexity: O(n * k), where n is the number of strings in strs, and k is the maximum length of a string in strs.
     * Space Complexity: O(n * k)
     * Runtime: 6 ms, faster than 98.92% of Java online submissions for Group Anagrams.
     * Memory Usage: 49.64 MB, less than 39.25% of Java online submissions for Group Anagrams.
     */
    public List<List<String>> groupAnagramsUsingHashMapAndContainsKey(String[] strs) {
        if (strs == null || strs.length == 0) 
            return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) { // O(n)
            char[] ca = new char[26];
            for (char c : s.toCharArray()) // O(k)
                ca[c - 'a']++;
        
            String keyStr = String.valueOf(ca);
            
            if (!map.containsKey(keyStr)) 
                map.put(keyStr, new ArrayList<>());
        
            map.get(keyStr).add(s);
        }

        return new ArrayList<>(map.values()); // O(n)
    }

    /**
     * @author: @LeetCode
     * Time Complexity: O(n * k log k), where n is the number of strings in strs, and k is the maximum length of a string in strs.
     * Space Complexity: O(n * k)
     * Runtime: 7 ms, faster than 71.28% of Java online submissions for Group Anagrams.
     * Memory Usage: 49.34 MB, less than 62.08% of Java online submissions for Group Anagrams.
     */
    public List<List<String>> groupAnagramsUsingHashMapAndSort(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String c : strs) { // O(n)
            char[] chars = c.toCharArray();
            Arrays.sort(chars); // O(k log k)
            String key = new String(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(c);
        }

        return new ArrayList<>(map.values());
    }
}