package au.com.rainmore.calculator.operators;

import java.math.BigDecimal;

public class Add implements Operator {

    @Override
    public BigDecimal operate(BigDecimal left, BigDecimal right) {
        assert left != null && right != null;
        return left.add(right);
    }
}
