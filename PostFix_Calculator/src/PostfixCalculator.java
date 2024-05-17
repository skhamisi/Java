import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class PostfixCalculator {

    public static int evaluatePostfix(String expression) {
      if (expression == null || expression.isEmpty()) {
        System.out.println("Error: Empty expression.");
        return 0;
      }
  
      Stack<Integer> stack = new Stack<>();
      String[] tokens = expression.split("\\s+");
  
      /*
       * Replaced isInteger() method with try/catch to handle the NumberFormatException
       * 
       */
      for (String token : tokens) {
        try {
          int operand2;
          switch (token) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
              if (stack.size() < 2) {
                System.out.println("Error: Invalid postfix expression.");
                return 0;
              }
              operand2 = stack.pop();
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

                break;
                
                default:
                    stack.push(Integer.parseInt(token));
            }
        } catch (NumberFormatException e) {
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
  
    public static void main(String[] args) {
      // Hardcoded values to test program
      String expression1 = "32 5 * 10 +";
      String expression2 = "5 2 + 10 *";
      String expression3 = "5 0 /"; // Division by zero, should display an error message
      String expression4 = "10 3 %"; // Modulus operation
  
      System.out.println("Result of " + expression1 + ": " + evaluatePostfix(expression1));
      System.out.println("Result of " + expression2 + ": " + evaluatePostfix(expression2));
      System.out.println("Result of " + expression3 + ": " + evaluatePostfix(expression3));
      System.out.println("Result of " + expression4 + ": " + evaluatePostfix(expression4));
  
      // Takes in text file to test program
      String fileName = "expressions.txt"; // Example txt file, replace with your file name before running program
  
      try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
  
        String line;
  
        while ((line = reader.readLine()) != null) {
          System.out.println("Result of " + line + ": " + evaluatePostfix(line.trim()));
        }
      } catch (Exception e) {
        System.err.println("Error reading file: " + e.getMessage());
      }
    }
  }