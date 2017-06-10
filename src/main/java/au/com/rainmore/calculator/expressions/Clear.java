package au.com.rainmore.calculator.expressions;

import java.math.BigDecimal;
import java.util.Stack;

public class Clear implements Expression {

    @Override
    public BigDecimal interpret(final Stack<Expression> variables) {
        variables.clear();
        return null;
    }
}
