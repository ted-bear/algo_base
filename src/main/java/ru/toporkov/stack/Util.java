package ru.toporkov.stack;

import java.util.List;

public class Util {

    public static boolean isBalanced(String brackets) {
        List<Character> openBrackets = List.of('(', '[', '{');
        Stack<Character> stack = new Stack<>();

        for (Character bracket : brackets.toCharArray()) {
            if (openBrackets.contains(bracket)) {
                stack.push(bracket);
            } else {
                if (stack.size() > 0) {
                    Character lastOpenBracket = stack.pop();
                    if (!isPair(lastOpenBracket, bracket)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    private static boolean isPair(Character lastOpenBracket, Character bracket) {
        if (bracket == ')') {
            return lastOpenBracket == '(';
        } else if (bracket == ']') {
            return lastOpenBracket == '[';
        } else if (bracket == '}') {
            return lastOpenBracket == '{';
        }

        return true;
    }
}
