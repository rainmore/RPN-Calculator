package au.com.rainmore.calculator.expression;

import java.math.BigDecimal;

public class Sqrt extends Operation {

    public Sqrt(Expression left) {
        super(left, null, Symbol.SQRT);
    }

    @Override
    public BigDecimal getResult() {
        Double value = Math.sqrt(getLeft().getResult().doubleValue());
        return new BigDecimal(value);
    }
}
