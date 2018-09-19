package medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

	@Test
	void lengthOfLongestSubstring() {
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		assertEquals( 3, obj.lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1 , obj.lengthOfLongestSubstring("bbbbb"));
		assertEquals( 3, obj.lengthOfLongestSubstring("pwwkew"));
	}
}