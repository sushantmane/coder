package hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestValidParenthesesTest {

	@Test
	public void longestValidParenthesesTest() {
		LongestValidParentheses lvp = new LongestValidParentheses();
		assertEquals(6, lvp.longestValidParentheses("())()((()()()"));
		assertEquals(4, lvp.longestValidParentheses("(()(())"));
		assertEquals(2, lvp.longestValidParentheses("()"));
	}
}