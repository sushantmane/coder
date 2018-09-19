/**
 * Problem: 32. Longest Valid Parentheses
 * Link: https://leetcode.com/problems/longest-valid-parentheses/description
 * Status: Incomplete
 */

package hard;

import java.util.Stack;

public class LongestValidParentheses {

	int lvpLen = 0;
	Stack<Character> stack = new Stack<>();

	public int longestValidParentheses(String s) {
		int current = 0;

		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push('(');
				continue;
			}

			if (c == ')') {
				if (stack.empty()) {
					if (lvpLen < current) {
						lvpLen = current;
					}
					current = 0;
				} else if (stack.peek() == '(') {
					stack.pop();
					current += 2;
				}
			}
		}

		if (lvpLen < current) {
			lvpLen = current;
		}

		System.out.println("A: " + lvpLen + " B: " + current);
		return lvpLen;
	}
}
