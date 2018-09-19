/**
 * Problem: 20. Valid Parentheses
 * Link: https://leetcode.com/problems/valid-parentheses/description
 * Status: Complete
 */

package easy;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		if (s.length() == 0) {
			return true;
		}

		Stack<Character> stack = new Stack<>();
		HashMap<Character, Character> brackets = new HashMap();
		brackets.put('(', ')');
		brackets.put('{', '}');
		brackets.put('[', ']');

		for (char c : s.toCharArray()) {
			if (brackets.containsKey(c)) {
				stack.push(c);
				continue;
			}
			if (!stack.empty() && brackets.get(stack.peek()) == c) {
				stack.pop();
				continue;
			}
			return false;
		}

		if (stack.empty()) {
			return true;
		}
		return false;
	}
}
