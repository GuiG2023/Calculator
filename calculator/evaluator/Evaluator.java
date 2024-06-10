package calculator.evaluator;

import calculator.operators.*;

import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator {

    private final Stack<Operand> operandStack;
    private final Stack<Operator> operatorStack;


    public Evaluator() { // create to stacks to push and pop operand and operator
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public int evaluateExpression(String expression) throws InvalidTokenException {
        String expressionToken;
        StringTokenizer expressionTokenizer;
        String delimiters = " +/*-^()"; // add 2 to pass the test ()

        // 3 arguments tells the tokenizer to return delimiters as tokens
        expressionTokenizer = new StringTokenizer(expression, delimiters, true);

        while (expressionTokenizer.hasMoreTokens()) {
            // filter out spaces
            if (!(expressionToken = expressionTokenizer.nextToken()).equals(" ")) {
                // check if token is an operand
                if (Operand.check(expressionToken)) {
                    operandStack.push(new Operand(expressionToken));
                } else {
                    if (!Operator.check(expressionToken)) {
                        throw new InvalidTokenException(expressionToken);
                    }


                    // TODO fix this line of code.
                    Operator newOperator = Operator.getOperator(expressionToken);
                    boolean checkSize = false;
                    //TODO protect the emptystackexception
                    if (expressionToken.equals("(")) {
                        operatorStack.push(newOperator);
                    } else if (expressionToken.equals(")")) {
                        while (!operatorStack.isEmpty() && !operatorStack.peek().toString().equals("(")) {//pop and calculate until "("
                            Operator operatorFromStack = operatorStack.pop();
                            Operand operandTwo = operandStack.pop();
                            Operand operandOne = operandStack.pop();
                            Operand result = operatorFromStack.execute(operandOne, operandTwo);
                            operandStack.push(result);

                        }
                        operatorStack.pop(); // pop "("
                    } else {
                        while (!operatorStack.isEmpty() && operatorStack.peek().priority() >= newOperator.priority()) {
//                              operand emptystack protect
//                            if (operandStack.size() <= 2) {
//                          break;
//                       }
                            Operator operatorFromStack = operatorStack.pop();
                            Operand operandTwo = operandStack.pop();
                            Operand operandOne = operandStack.pop();
                            Operand result = operatorFromStack.execute(operandOne, operandTwo);
                            operandStack.push(result);
                        }
                        operatorStack.push(newOperator);
                    }
                }
            }
        }

        /*
         * once no more tokens need to be scanned from StringTokenizer,
         * we need to evaluate the remaining sub-expressions.
         */

        while (!operatorStack.isEmpty()) {
            Operator operatorFromStack = operatorStack.pop();
            Operand operandTwo = operandStack.pop();
            Operand operandOne = operandStack.pop();
            Operand result = operatorFromStack.execute(operandOne, operandTwo);
            operandStack.push(result);
        }
        return operandStack.pop().getValue();
    }

    public static void main(String[] args) throws InvalidTokenException {
        if (args.length == 1) {
            Evaluator e = new Evaluator();
            System.out.println(e.evaluateExpression(args[0]));
        } else {
            System.err.println("Invalid arguments or No expression given");
        }
    }

}
