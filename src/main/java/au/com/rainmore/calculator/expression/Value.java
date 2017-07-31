package au.com.rainmore.calculator.expression;

import java.math.BigDecimal;

public class Value implements Expression {

    private final BigDecimal value;

    public Value(String value) {
        this(new BigDecimal(value));
    }

    public Value(BigDecimal value) {
        this.value = value;
    }

    @Override
    public BigDecimal getResult() {
        return value;
    }
}
