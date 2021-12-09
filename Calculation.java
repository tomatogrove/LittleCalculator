import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculation {

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    /**
     * operation uses 3 variables to calculate the result with
     * @return result of equation
     */
    public static int operation() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter first int: ");
        int variableOne = scan.nextInt();
        System.out.println("Enter operator: ");
        char operator = scan.next().charAt(0);
        System.out.println("Enter second int: ");
        int variableTwo = scan.nextInt();
        int result = 0;

        if (operator == '+') {
            result = variableOne + variableTwo;
        } else if (operator == '-') {
            result = variableOne - variableTwo;
        } else if (operator == '*') {
            result = variableOne * variableTwo;
        } else if (operator == '/') {
            result = variableOne / variableTwo;
        }

        return result;
    }

    /**
     * operation2 uses an array to contain the size
     * @return result of equation
     */
    public static int operation2() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your calculation: ");
        String input = scan.next();
        int[] inputs = new int[2];
        char[] operators = new char[1];
        int count = 0;
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                String addNum = Integer.toString(inputs[count]) + input.charAt(i);
                inputs[count] = Integer.parseInt(addNum);
            } else {
                operators[0] = input.charAt(i);
                count++;
            }
        }

        if (operators[0] == '+') {
            result = inputs[0] + inputs[1];
        } else if (operators[0] == '-') {
            result = inputs[0] - inputs[1];
        } else if (operators[0] == '*') {
            result = inputs[0] * inputs[1];
        } else if (operators[0] == '/') {
            result = inputs[0] / inputs[1];
        }

        return result;
    }

    /**
     * operation3 now adds lists and has a variable size
     * @return result of equation
     */
    public static int operation3() {
        Scanner scan = new Scanner(System.in);
        List<Integer> inputs = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        System.out.println("Enter your calculation: ");
        String input = scan.next();
        int count = 0;
        int result;
        String addNum;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                if (inputs.size() <= count) {
                    addNum = Character.toString(input.charAt(i));
                    inputs.add(count, Integer.parseInt(addNum));
                } else {
                    addNum = Integer.toString(inputs.get(count)) + input.charAt(i);
                    inputs.set(count, Integer.parseInt(addNum));
                }
            } else {
                operators.add(input.charAt(i));
                count++;
            }
        }

        result = inputs.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '+') {
                result += inputs.get(i+1);
            } else if (operators.get(i) == '-') {
                result -= inputs.get(i+1);
            } else if (operators.get(i) == '*') {
                result *= inputs.get(i+1);
            } else if (operators.get(i) == '/') {
                result /= inputs.get(i+1);
            }
        }

        return result;
    }

    public static int operation4() {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        System.out.println("Enter your calculation: ");
        String input = scan.next();
        return operation4(input, opStack, numStack);
    }
    private static int operation4(String input, Stack<Character> opStack, Stack<Integer> numStack) {
        if (input.isEmpty()) {
            return numStack.pop();
        } else if (input.charAt(0) <= '9' && input.charAt(0) >= '0') {
            numStack.push(Integer.parseInt(input.substring(0,1)));
            input = input.substring(1);
            return operation4(input, opStack, numStack);
        } else if (input.charAt(0) == ')') {
            numStack.push(calculate(numStack.pop(), opStack.pop(), numStack.pop()));
            input = input.substring(1);
            return operation4(input, opStack, numStack);
        } else if (input.charAt(0) != '(') {
            opStack.push(input.charAt(0));
            input = input.substring(1);
            return operation4(input, opStack, numStack);
        } else {
            input = input.substring(1);
            return operation4(input, opStack, numStack);
        }
    }

    public static int operation5() {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> numStack = new Stack<>();
        Stack<String> opStack = new Stack<>();

        System.out.println("Enter your calculation: ");
        String input = scan.next();

        return 1;
    }

    private static int calculate(int num1, char operator, int num2) {
        if (operator == '*') {
            return num2 * num1;
        } else if (operator == '/') {
            return num2 / num1;
        } else if (operator == '+') {
            return num2 + num1;
        } else {
            return num2 - num1;
        }
    }

    private static int compareTo(char operator) {
        return 1;
    }
}
