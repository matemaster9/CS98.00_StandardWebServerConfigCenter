package cs.matemaster.effective_java;

/**
 * @author matemaster
 */
public enum Operation2 {
    Plus,

    Minus,

    Times,

    Divide,

    Modulo,
    ;

    public double apply(double x, double y) {
        switch (this) {
            case Plus:
                return x + y;
            case Minus:
                return x - y;
            case Times:
                return x * y;
            case Divide:
                return x / y;
        }
        throw new AssertionError("unknown operation : " + this);
    }
}
