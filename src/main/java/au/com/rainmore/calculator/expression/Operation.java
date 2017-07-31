package au.com.rainmore.calculator.expression;

abstract public class Operation implements Expression {
    private final Expression left;
    private final Expression right;
    private final Symbol     symbol;

    protected Operation(Expression left, Expression right, Symbol symbol) {
        this.left = left;
        this.right = right;
        this.symbol = symbol;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}

