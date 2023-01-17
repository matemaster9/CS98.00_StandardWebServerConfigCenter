package cs.matemaster.effective_java;

/**
 * @author matemaster
 */
public enum Operation3 implements IOperation{

    Plus("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    Minus("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    Times("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    Divide("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    },
    ;

    private final String symbol;

    Operation3(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
