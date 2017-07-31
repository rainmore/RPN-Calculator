package au.com.rainmore.calculator.expression;

import java.math.BigDecimal;

public class Multiple extends Operation {

    public Multiple(Expression left, Expression right) {
        super(left, right, Symbol.MULTIPLE);
    }

    @Override
    public BigDecimal getResult() {
        return getLeft().getResult().multiply(getRight().getResult());
    }
}
