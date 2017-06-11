package au.com.rainmore.calculator.expressions;

import au.com.rainmore.calculator.operators.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Stack;

public class Number implements Expression {

    private static DecimalFormat DECIMALFORMAT = buildDecimalFormat("#,##0.#", 15, RoundingMode.UP);
    private static DecimalFormat DECIMALFORMAT_DISPLAY = buildDecimalFormat("#.##########", 10, RoundingMode.UNNECESSARY);

    final private BigDecimal value;

    public Number(String value) throws ParseException {
        this.value = (BigDecimal) DECIMALFORMAT.parse(value);
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
        return DECIMALFORMAT_DISPLAY.format(value);
    }

    private static DecimalFormat buildDecimalFormat(String format, int decimals, RoundingMode roundingMode) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = format;

        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);
        decimalFormat.setMaximumFractionDigits(decimals);
        decimalFormat.setRoundingMode(roundingMode);

        return decimalFormat;
    }

}
