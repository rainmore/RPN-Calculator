package au.com.rainmore.calculator.expressions;

import java.util.Stack;

public class Undo extends Expression {

    @Override
    public void interpret(final Stack<Expression> variables) {
        if (!variables.empty()) {
            if (variables.peek() instanceof Number) {
               variables.pop();
            }
            else if (variables.peek() instanceof Operator) {
                Operator operator = (Operator) variables.pop();
                if (operator.getLeft() != null) {
                    variables.push(operator.getLeft());
                }

                if (operator.getRight() != null) {
                    variables.push(operator.getRight());
                }
            }

        }
    }
}
