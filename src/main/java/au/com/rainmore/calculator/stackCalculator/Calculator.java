package au.com.rainmore.calculator.stackCalculator;

import au.com.rainmore.calculator.expression.*;

import java.math.BigDecimal;
import java.util.Stack;

public class Calculator {

    private final Stack<Expression> stack = new Stack<>();

    public Stack<Expression> getStack() {
        return stack;
    }

    public Calculator push(Expression expression) {
        stack.add(expression);
        return this;
    }

    public Calculator push(Symbol symbol) {
        if (stack.isEmpty() || stack.size() < symbol.parameterSize()) {
            throw new InsufficientParametersException();
        }

        Expression left;
        Expression right;

        switch (symbol) {
            case SQRT:
                left = stack.pop();
                stack.push(new Sqrt(left));
                break;
            case ADD:
                right = stack.pop();
                left = stack.pop();
                stack.push(new Add(left, right));
                break;
            case SUBTRACT:
                right = stack.pop();
                left = stack.pop();
                stack.push(new Subtract(left, right));
                break;
            case MULTIPLE:
                right = stack.pop();
                left = stack.pop();
                stack.push(new Multiple(left, right));
                break;
            case DIVIDE:
                if (stack.peek().getResult().equals(BigDecimal.ZERO)) {
                    throw new IllegalArgumentException("Divide by Zero");
                }
                right = stack.pop();
                left = stack.pop();
                stack.push(new Divide(left, right));
                break;
        }

        return this;
    }

    public Calculator clear() {
        stack.removeAllElements();
        return this;
    }

    public Calculator undo() {
        if (!stack.isEmpty()) {
            Expression expression = stack.peek();
            if (expression instanceof Value) {
                stack.pop();
            }
            else if (expression instanceof Operation) {
                stack.pop();
                stack.push(((Operation) expression).getLeft());
                stack.push(((Operation) expression).getRight());
            }
        }

        return this;
    }
}
