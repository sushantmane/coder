/**
 * Problem: 3. Longest Substring Without Repeating Characters
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description
 * Status: Complete
 */

package medium;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		int zLen = 0;
		int yLen = 0;

		HashMap<Character, Integer> map = new LinkedHashMap<>();
		int index = 0;
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				int charPos = map.get(c);
				map.entrySet().removeIf(e -> (e.getValue() <= charPos));
				if (zLen < yLen) {
					zLen = yLen;
				}
				map.put(c, index);
				yLen = map.size();
			} else {
				yLen++;
				map.put(c, index);
			}

			index++;
		}

		if (zLen < yLen) {
			zLen = yLen;
		}

		return zLen;
	}
}
