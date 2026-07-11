class Solution {
    public boolean isOpeningBracket(char ch) {
        return ((ch == '(') || (ch == '{') || (ch == '['));
    }
    
    public boolean areBracketPair(char ob, char cb) {
        if ((ob == '(') && (cb == ')')) return true;
        if ((ob == '{') && (cb == '}')) return true;
        if ((ob == '[') && (cb == ']')) return true;
        return false;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch: s.toCharArray()) {
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;

                char ob = stack.pop();
                if (!areBracketPair(ob, ch)) return false;
            }
        }
        if (!stack.isEmpty()) return false;

        return true;
    }
}
