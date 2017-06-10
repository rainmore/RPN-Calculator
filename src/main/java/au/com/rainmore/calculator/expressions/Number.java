package au.com.rainmore.calculator.expressions;

import au.com.rainmore.calculator.operators.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Stack;

public class Number implements Expression {

    private static DecimalFormat decimalFormat = buildDecimalFormat();

    final private BigDecimal value;

    public Number(String value) throws ParseException {
        this.value = (BigDecimal) decimalFormat.parse(value);
    }

    public Number(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public BigDecimal interpret(final Stack<Expression> variables) {
        variables.push(new Number(value));
        return value;
    }

    @Override
    public String toString() {
        BigDecimal print = value.setScale(10, BigDecimal.ROUND_UP);
        return print.toString();
    }

    private static DecimalFormat buildDecimalFormat() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "#,##0.0#";

        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);

        return decimalFormat;
    }

}
