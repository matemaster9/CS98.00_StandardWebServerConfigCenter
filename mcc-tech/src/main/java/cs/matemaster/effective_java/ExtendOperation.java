package cs.matemaster.effective_java;

/**
 * @author matemaster
 */
public enum ExtendOperation implements IOperation {

    Exponentiation("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },

    Remainder("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    @Override
    public double apply(double x, double y) {
        return 0;
    }
}
