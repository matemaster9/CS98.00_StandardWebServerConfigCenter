package cs.matemaster.effective_java;

import java.util.function.DoubleBinaryOperator;

/**
 * @author matemaster
 */
public enum OperationLambda {

    Plus("+", Double::sum),

    Minus("-", (x, y) -> x - y),

    Times("*", (x, y) -> x * y),

    Divide("/", (x, y) -> x / y),

    Modulo("%", (x, y) -> x % y),

    Exponentiation("^", Math::pow),

    ;

    private final String symbol;

    private final DoubleBinaryOperator binaryOperator;

    OperationLambda(String symbol, DoubleBinaryOperator binaryOperator) {
        this.symbol = symbol;
        this.binaryOperator = binaryOperator;
    }

    public double apply(double x, double y) {
        return binaryOperator.applyAsDouble(x, y);
    }


    @Override
    public String toString() {
        return symbol;
    }
}
