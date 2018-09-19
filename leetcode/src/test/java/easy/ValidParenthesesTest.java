package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

	private ValidParentheses vp;

	@BeforeEach
	void beforeEach() {
		vp = new ValidParentheses();
	}

	@ParameterizedTest
	@ValueSource(strings = { "()", "()[]{}", "{[]}" })
	void testIsValid_True(String s) {
		assertTrue(vp.isValid(s));
	}

	@ParameterizedTest
	@ValueSource(strings = { "(]", "([)]", "]", "()]" })
	void testIsValid_False(String s) {
		assertFalse(vp.isValid(s));
	}
}