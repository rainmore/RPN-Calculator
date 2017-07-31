package au.com.rainmore.calculator.expression;

import java.math.BigDecimal;

public class Add extends Operation {

    public Add(Expression left, Expression right) {
        super(left, right, Symbol.ADD);
    }

    @Override
    public BigDecimal getResult() {
        return getLeft().getResult().add(getRight().getResult());
    }
}
