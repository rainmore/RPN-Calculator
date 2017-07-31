package au.com.rainmore.calculator;

import au.com.rainmore.calculator.stackCalculator.Calculator;
import au.com.rainmore.calculator.stackCalculator.CalculatorRender;

import java.io.Console;

public class Application {

    public static void main(String[] args) {
        Console c = System.console();

        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        CalculatorInterpreter interpreter = new CalculatorInterpreter(System.console(), new Calculator(), new CalculatorRender());

        interpreter.run();

    }
}
