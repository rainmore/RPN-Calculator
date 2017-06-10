package au.com.rainmore.calculator.expressions;


import java.math.BigDecimal;
import java.util.Stack;

public interface Expression {

    BigDecimal interpret(final Stack<Expression> variables);
}
