import java.util.Stack;

public class PostfixCalculator {

    public static int evaluatePostfix(String expression) {
        if (expression == null || expression.isEmpty()) {
            System.out.println("Error: Empty expression.");
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isInteger(token)) {
                stack.push(Integer.parseInt(token));
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%")) {
                if (stack.size() < 2) {
                    System.out.println("Error: Invalid postfix expression.");
                    return 0;
                }

                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        if (operand2 == 0) {
                            System.out.println("Error: Division by zero.");
                            return 0;
                        }
                        stack.push(operand1 / operand2);
                        break;
                    case "%":
                        if (operand2 == 0) {
                            System.out.println("Error: Modulus by zero.");
                            return 0;
                        }
                        stack.push(operand1 % operand2);
                        break;
                }
            } else {
                System.out.println("Error: Invalid character in expression.");
                return 0;
            }
        }

        if (stack.size() != 1) {
            System.out.println("Error: Invalid expression.");
            return 0;
        }

        return stack.pop();
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String expression1 = "32 5 * 10 +";
        String expression2 = "5 2 + 10 *";
        String expression3 = "5 0 /"; // Division by zero, should display an error message
        String expression4 = "10 3 %"; // Modulus operation

        System.out.println("Result of " + expression1 + ": " + evaluatePostfix(expression1));
        System.out.println("Result of " + expression2 + ": " + evaluatePostfix(expression2));
        System.out.println("Result of " + expression3 + ": " + evaluatePostfix(expression3));
        System.out.println("Result of " + expression4 + ": " + evaluatePostfix(expression4));
    }
}
