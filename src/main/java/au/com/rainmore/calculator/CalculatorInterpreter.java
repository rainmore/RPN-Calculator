package au.com.rainmore.calculator;

import au.com.rainmore.calculator.expression.Symbol;
import au.com.rainmore.calculator.expression.Value;
import au.com.rainmore.calculator.stackCalculator.Calculator;
import au.com.rainmore.calculator.stackCalculator.CalculatorRender;
import au.com.rainmore.calculator.stackCalculator.InsufficientParametersException;

import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorInterpreter {

    private Console          console;
    private Calculator       calculator;
    private CalculatorRender render;

    public CalculatorInterpreter(Console console, Calculator calculator, CalculatorRender calculatorRender) {
        this.console    = console;
        this.calculator = calculator;
        this.render     = calculatorRender;
    }

    public void run() {
        while (true) {
            input();
        }
    }

    private void input() {
        String input = console.readLine("Please enter number and operators(+, -, *, /, sqrt, undo, clear) separated with a white space: ");

        List<String> result = sanitize(input);

        if (result.isEmpty()) {
            println("Please provide input value.");
            return;
        }

        int bound = result.size();
        for (int idx = 0; idx < bound; idx++) {
            String variable = result.get(idx);
            Integer position = (idx * 2) + 1;

            println(String.format("\tInput variable `%s`.", variable));

            if (variable.equalsIgnoreCase("undo")) {
                calculator.undo();
            } else if (variable.equalsIgnoreCase("clear")) {
                calculator.clear();
            } else if (Symbol.isSymble(variable)) {
                try {
                    calculator.push(Symbol.forValue(variable));
                }
                catch (InsufficientParametersException ex) {
                    println(String.format("\n\toperator %s (position: %s): insufficient parameters", variable, position));
                    break;
                }
                catch (Exception ex) {
                    println(String.format("\n\toperator %s (position: %s): %s", variable, position, ex.getMessage()));
                    break;
                }
            } else {
                try {
                    calculator.push(new Value(variable));
                }
                catch (NumberFormatException ex) {
                    println(String.format("\n\tinput %s (position: %s): invalid number", variable, position));
                    break;
                }
                catch (Exception ex) {
                    println(String.format("\n\tinput %s (position: %s): %s", variable, position, ex.getMessage()));
                    break;
                }
            }
        }

        println(String.format("\n\tCalculator stack: %s\n", render.render(calculator)));

    }

    private List<String> sanitize(String input) {
        return Arrays.stream(input.split(" "))
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toList());

    }

    private void println(String string) {
        System.out.println(string);
    }
}
