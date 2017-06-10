package au.com.rainmore.calculator.operators;

import java.math.BigDecimal;

public class Sqrt implements Operator {

    @Override
    public BigDecimal operate(BigDecimal left, BigDecimal right) {
        assert left != null;
        return sqrt(left);
    }

    private BigDecimal sqrt(BigDecimal value) {
        return sqrt(value, 15);
    }

    /**
     *
     * Copied from https://stackoverflow.com/a/19743026/568005
     *
     * @param value
     * @param scale
     * @return result
     */
    private BigDecimal sqrt(BigDecimal value, final int scale) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(value.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = value.divide(x0, scale, BigDecimal.ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(BigDecimal.TEN, scale, BigDecimal.ROUND_HALF_UP);
        }

        return x1;
    }
}
