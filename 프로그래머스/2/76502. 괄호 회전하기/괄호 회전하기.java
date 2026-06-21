import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();

        for (int x = 0; x < len; x++) {
            String rotated = s.substring(x) + s.substring(0, x);

            if (isCorrect(rotated)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') {
                    return false;
                }

                if (c == ']' && top != '[') {
                    return false;
                }

                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}