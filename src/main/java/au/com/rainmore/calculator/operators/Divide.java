package au.com.rainmore.calculator.operators;

import java.math.BigDecimal;

public class Divide implements Operator {

    @Override
    public BigDecimal operate(BigDecimal left, BigDecimal right) {
        assert left != null && right != null && !right.equals(BigDecimal.ZERO);
        return left.divide(right, BigDecimal.ROUND_HALF_UP);
    }
}