package au.com.rainmore.calculator.operators;

import java.math.BigDecimal;

public interface Operator {

    BigDecimal operate(BigDecimal left, BigDecimal right);

}
