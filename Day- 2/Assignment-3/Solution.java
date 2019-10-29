/**
 * class to check if the given input satisfies the condition.
 */
public class Solution {

    /**
     * function to give check for the condition and give output.
     * @param s the combination of brackets.
     * @return 'YES' if condition is satisfied, else 'NO'.
     */
    public static String isMatching(final String s) {
        Stack openers = new Stack(s.length() / 2);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{'
                    || s.charAt(i) == '(') {
                openers.push(Character.toString(s.charAt(i)));
            } else if (s.charAt(i) == ']') {
                if (openers.isEmpty()) {
                    return "NO";
                } else if (openers.pop().equals("[")) {
                    continue;
                } else {
                    return "NO";
                }
            } else if (openers.isEmpty()) {
                return "NO";
            } else if (s.charAt(i) == '}') {
                if (openers.pop().equals("{")) {
                    continue;
                } else {
                    return "NO";
                }
            } else if (openers.isEmpty()) {
                return "NO";
            }else if (s.charAt(i) == ')') {
                if (openers.pop().equals("(")) {
                    continue;
                } else {
                    return "NO";
                }
            }
        }
        if (!openers.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

    /**
     * main function.
     * @param args main function arguments.
     */
    public static void main(final String[] args) {
        Check check = new Check();
        String s = "[()]{}{[()()]()}";

        System.out.println(check.isMatching(s));

        s = "[(])";

        System.out.println(check.isMatching(s));
    }
}
