package au.com.rainmore.calculator.expressions;

import java.math.BigDecimal;
import java.util.Stack;

abstract class Operator<T extends au.com.rainmore.calculator.operators.Operator> implements Expression {

    final private T operator;

    protected Operator(T operator) {
        this.operator = operator;
    }

    public T getOperator() {
        return operator;
    }

    protected Integer getParameterSize() {
        return 2;
    }

    @Override
    public BigDecimal interpret(final Stack<Expression> variables) {
        int size = variables.size();
        if (size < getParameterSize()) {
            System.out.println(buildErrorMessage(size));
            return null;
        }

        BigDecimal result = calculate(variables);
        variables.add(new Number(result));

        return result;
    }

    protected BigDecimal calculate(final Stack<Expression> variables) {
        Number right = (Number) variables.pop();
        Number left = (Number) variables.pop();

        return getOperator().operate(left.getValue(), right.getValue());
    }

    @Override
    public String toString() {
        return getOperator().getClass().getSimpleName().toLowerCase();
    }

    protected String buildErrorMessage(int position) {
        return String.format("operator * (position: %s): insufficient parameters", position);
    }
}
