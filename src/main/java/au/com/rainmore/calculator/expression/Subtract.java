package au.com.rainmore.calculator.expression;

import java.math.BigDecimal;

public class Subtract extends Operation {

    public Subtract(Expression left, Expression right) {
        super(left, right, Symbol.SUBTRACT);
    }

    @Override
    public BigDecimal getResult() {
        return getLeft().getResult().subtract(getRight().getResult());
    }
}
