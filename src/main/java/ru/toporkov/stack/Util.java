package ru.toporkov.stack;

import java.util.Map;

public class Util {

    public static boolean isBalanced(String brackets) {
        Map<Character, Character> pairs = Map.of(
                '(', ')',
                '{', '}',
                '[', ']'
        );
        Stack<Character> stack = new Stack<>();

        for (Character bracket : brackets.toCharArray()) {
            if (pairs.containsKey(bracket)) {
                stack.push(bracket);
                continue;
            }

            if (stack.size() == 0) {
                return false;
            }

            Character lastOpenBracket = stack.pop();
            if (!pairs.get(lastOpenBracket).equals(bracket)) {
                return false;
            }
        }

        return stack.size() == 0;
    }

    public static Integer calculateReverse(Stack<String> inStack) {
        Stack<Integer> resultStack = new Stack<>();

        while (inStack.size() >= 0) {
            String currentElement = inStack.pop();
            if (isNumber(currentElement)) {
                resultStack.push(Integer.parseInt(currentElement));
            } else if (currentElement.equals("=")) {
                return resultStack.peek();
            } else {
                Integer firstElement = resultStack.pop();
                Integer secondElement = resultStack.pop();
                resultStack.push(calculate(firstElement, secondElement, currentElement));
            }
        }

        return resultStack.peek();
    }

    private static Integer calculate(Integer first, Integer second, String operation) {
        if (operation.equals("+")) {
            return first + second;
        } else if (operation.equals("*")) {
            return first * second;
        }

        throw new RuntimeException("No such operation");
    }

    private static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
