import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s == null)
            return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ('{' == c || '[' == c || '(' == c) {
                stack.push(c);
            } else {
                switch (c) {
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
}