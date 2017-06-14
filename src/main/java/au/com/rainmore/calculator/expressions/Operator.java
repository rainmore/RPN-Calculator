package au.com.rainmore.calculator.expressions;

import java.math.BigDecimal;
import java.util.Stack;

abstract public class Operator<T extends au.com.rainmore.calculator.operators.Operator> extends Expression {

    final private T operator;

    private Expression left;
    private Expression right;

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
    public void interpret(final Stack<Expression> variables) throws RuntimeException {
        try {
            int size = variables.size();
            if (size < getParameterSize()) {
                throw new IllegalArgumentException(String.format("operator * (position: %s): insufficient parameters", size));
            }

            if (getParameterSize() > 1) {
                right = variables.pop();
            }

            left = variables.pop();

            setResult(calculate());
            variables.add(this);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    protected BigDecimal calculate() {
        return getOperator().operate(left.getResult(), right != null ? right.getResult() : null);
    }
}
