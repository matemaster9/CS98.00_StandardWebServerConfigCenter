import cs.matemaster.effective_java.ExtendOperation;
import cs.matemaster.effective_java.IOperation;
import cs.matemaster.effective_java.Operation;
import cs.matemaster.effective_java.Operation2;
import cs.matemaster.effective_java.Operation3;
import cs.matemaster.standardwebserver.common.util.DataFakerUtil;
import org.junit.Test;

import java.util.Optional;

/**
 * @author matemaster
 */
public class OperationCase {

    public static void main(String[] args) {
        double number1 = DataFakerUtil.localRandom.nextDouble();
        double number2 = DataFakerUtil.localRandom.nextDouble();

        double arg1 = Math.abs(number1);
        double arg2 = Math.abs(number2);

        for (Operation operation : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", arg1, operation, arg2, operation.apply(arg1, arg2));
        }
    }

    @Test
    public void fromSymbol() {
        Optional<Operation> operation = Operation.fromSymbol("%");
        Operation elseThrow = operation.orElseThrow(() -> new IllegalArgumentException("非法操作"));
        double apply = elseThrow.apply(1.0, 2.0);
        System.out.println(apply);
    }

    @Test
    public void operation2() {
        double apply = Operation2.Modulo.apply(1, 2);
        System.out.println(apply);
    }

    @Test
    public void iOperation() {
        test(Operation3.class, 1, 2);
        test(ExtendOperation.class, 1, 2);
    }

    private <T extends Enum<T> & IOperation> void test(Class<T> op, double x, double y) {
        T[] enumConstants = op.getEnumConstants();
        for (T enumConstant : enumConstants) {
            System.out.printf("%f %s %f = %f%n", x, enumConstant, y, enumConstant.apply(x, y));
        }
    }

    @Test
    public void inverseOperation() {
        Operation inverse = inverse(Operation.Plus);
        System.out.println(inverse);
    }

    public static Operation inverse(Operation opr) {
        switch (opr) {
            case Plus:
                return Operation.Minus;
            case Minus:
                return Operation.Plus;
            case Times:
                return Operation.Divide;
            case Divide:
                return Operation.Times;
            default:
                throw new AssertionError("unknown operation : " + opr);
        }
    }
}
