/*
 * Longest Substring Without Repeating Characters
 *
 * INITIAL SOLUTION
 *
 *
 * max (j - i + 1) = 2
 *                                Hasmap
 * abcadcda               i - j | key - value (j + 1)
 * 01234567               0 - 0 | a   - 1
 *                        0 - 1 | b   - 2
 *                        0 - 2 | c   - 3
 *                        0 - 3 | d   - 4
 *                        0 - 4 | a   - 5
 *
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        int j = 0;
        int i = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(map.get(c) + 1, i);
            }
            map.put(c, j);
            max = Math.max(max, j - i + 1);
            j++;
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcadcda";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
