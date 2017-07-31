package au.com.rainmore.calculator.expression;

import java.math.BigDecimal;

public class Divide extends Operation {

    public Divide(Expression left, Expression right) {
        super(left, right, Symbol.DIVIDE);
    }

    @Override
    public BigDecimal getResult() {
        return getLeft().getResult().divide(getRight().getResult());
    }
}
