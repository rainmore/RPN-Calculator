package au.com.rainmore.calculator.expressions;

import java.math.BigDecimal;
import java.util.Stack;

public class Divide extends Operator<au.com.rainmore.calculator.operators.Divide> {

    public Divide() {
        super(new au.com.rainmore.calculator.operators.Divide());
    }

    @Override
    protected BigDecimal calculate() {
        if (getRight().equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("Divided By Zero");
        }
        return super.calculate();
    }
}
