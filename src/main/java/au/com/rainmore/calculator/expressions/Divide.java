package au.com.rainmore.calculator.expressions;

import java.math.BigDecimal;
import java.util.Stack;

public class Divide extends Operator<au.com.rainmore.calculator.operators.Divide> {

    public Divide() {
        super(new au.com.rainmore.calculator.operators.Divide());
    }

    @Override
    protected BigDecimal calculate(final Stack<Expression> variables) {
        Number right = (Number) variables.pop();
        if (right.getValue().equals(BigDecimal.ZERO)) {
            variables.push(right);
            System.out.println(buildErrorMessage(variables.size()));
            return null;
        }
        Number left = (Number) variables.pop();

        return getOperator().operate(left.getValue(), right.getValue());
    }
}
