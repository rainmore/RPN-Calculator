package au.com.rainmore.calculator;

import au.com.rainmore.calculator.expressions.*;
import au.com.rainmore.calculator.expressions.Number;
import com.sun.javafx.binding.StringFormatter;

import java.io.Console;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Console c = System.console();

        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        Interpreter interpreter = new Interpreter(System.console(), new Calculator());

        interpreter.run();

    }


    private static class Interpreter {

        private Console console;
        private Calculator calculator;

        Interpreter(Console console, Calculator calculator) {
            this.console = console;
            this.calculator = calculator;
        }

        void run() {
            while (true) {
                input();
            }
        }

        private void input() {
            String input = console.readLine("Please enter number or operators (+, -, *, /, sqrt, undo, clear): ");

            List<String> result = sanitize(input);

            if (!result.isEmpty()) {
                result.forEach(variable -> {
                    println(String.format("\tInput variable `%s`.", variable));
                    convert(variable).map(expression -> calculator.push(expression));
                });

                println(String.format("\n\tCalculator stack: %s\n", calculator.toString()));
            }
            else {
                println("Please provide input value.");
            }
        }

        private Optional<Expression> convert(String variable) {
            Expression expression;
            try {
                switch (variable) {
                    case "clear":
                        expression = new Clear();
                        break;
                    case "undo":
                        expression = new Undo();
                        break;
                    case "sqrt":
                        expression = new Sqrt();
                        break;
                    case "+":
                        expression = new Add();
                        break;
                    case "-":
                        expression = new Subtract();
                        break;
                    case "*":
                        expression = new Multiply();
                        break;
                    case "/":
                        expression = new Divide();
                        break;
                    default:
                        expression = new Number(variable);
                }

                return Optional.of(expression);
            }
            catch (ParseException ex) {
                println(String.format("\tInvalid number `%s`. Please provide decimal number instead.", variable));
                return Optional.empty();
            }
        }

        private List<String> sanitize(String input) {
            return Arrays.stream(input.split(" "))
                    .filter(s -> s != null && !s.trim().isEmpty()).collect(Collectors.toList());

        }

        private void println(String string) {
            System.out.println(string);
        }
    }


}
