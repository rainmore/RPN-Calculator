package au.com.rainmore.calculator;

import au.com.rainmore.calculator.expressions.Expression;

import java.util.Stack;
import java.util.stream.Collectors;

public class Calculator {

    final private Stack<Expression> stack = new Stack<Expression>();

    public Calculator push(Expression item) {
        item.interpret(stack);
        return this;
    }

    public String toString() {
        return stack.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }

}
