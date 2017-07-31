package au.com.rainmore.calculator.stackCalculator;


import java.util.stream.Collectors;

public class CalculatorRender {

    public String render(Calculator calculator) {

        return calculator.getStack().stream()
                .map(expression -> expression.getResult().toPlainString())
                .collect(Collectors.joining(" "));
    }

}
