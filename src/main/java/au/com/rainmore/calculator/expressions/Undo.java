package au.com.rainmore.calculator.expressions;

import java.math.BigDecimal;
import java.util.Stack;

public class Undo implements Expression {

    @Override
    public BigDecimal interpret(final Stack<Expression> variables) {
        if (!variables.empty()) {
            variables.pop();
        }

        return null;
    }
}
