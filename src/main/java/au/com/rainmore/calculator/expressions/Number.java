package au.com.rainmore.calculator.expressions;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Stack;

public class Number extends Expression {

    public Number() {
    }

    public Number(String data) throws ParseException {
        setResult((BigDecimal) DECIMALFORMAT.parse(data));
    }

    @Override
    public void interpret(final Stack<Expression> variables) {
        variables.push(this);
    }

}
