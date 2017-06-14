package au.com.rainmore.calculator.expressions;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Stack;

public abstract class Expression {
    protected static DecimalFormat DECIMALFORMAT = buildDecimalFormat("#,##0.#", 15, RoundingMode.UP);
    private static DecimalFormat DECIMALFORMAT_DISPLAY = buildDecimalFormat("#.##########", 10, RoundingMode.UNNECESSARY);

    private BigDecimal result;

    abstract public void interpret(final Stack<Expression> variables);

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return DECIMALFORMAT_DISPLAY.format(getResult());
    }

    protected static DecimalFormat buildDecimalFormat(String format, int decimals, RoundingMode roundingMode) {
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
