package au.com.rainmore.calculator.expressions;

import java.math.BigDecimal;
import java.util.Stack;

public class Sqrt extends Operator<au.com.rainmore.calculator.operators.Sqrt> {

    public Sqrt() {
        super(new au.com.rainmore.calculator.operators.Sqrt());
    }

    @Override
    protected Integer getParameterSize() {
        return 1;
    }

    @Override
    protected BigDecimal calculate(final Stack<Expression> variables) {
        Number left = (Number) variables.pop();

        return getOperator().operate(left.getValue(), null);
    }
}
