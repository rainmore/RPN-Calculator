package au.com.rainmore.calculator.expressions;

import java.util.Stack;

public class Clear extends Expression {

    @Override
    public void interpret(final Stack<Expression> variables) {
        variables.clear();
    }
}
