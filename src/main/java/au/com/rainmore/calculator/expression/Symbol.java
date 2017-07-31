package au.com.rainmore.calculator.expression;

import java.util.Arrays;

public enum Symbol {
    ADD("+"), SUBTRACT("-"), MULTIPLE("*"), DIVIDE("/"), SQRT("sqrt");

    private final String code;

    Symbol(String code) {
        this.code = code;
    }

    public String value() {
        return this.code;
    }

    public String toString() {
        return this.value();
    }

    public Integer parameterSize() {
        switch (this) {
            case SQRT:
                return 1;
            default:
                return 2;
        }
    }

    public static Symbol forValue(String value) {
        return Arrays.stream(Symbol.values()).filter(code -> code.value().equals(value)).findFirst().orElse(null);
    }

    public static Boolean isSymble(String value) {
        return Arrays.stream(Symbol.values()).anyMatch(code -> code.value().equals(value));
    }


}
