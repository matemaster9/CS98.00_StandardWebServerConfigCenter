package cs.matemaster.effective_java;

import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author matemaster
 */
@Getter
public enum Operation {

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

    private static final Map<String, Operation> stringToEnum = Stream.of(values()).collect(Collectors.toMap(Operation::toString, t -> t));

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    @Override
    public String toString() {
        return symbol;
    }


}
