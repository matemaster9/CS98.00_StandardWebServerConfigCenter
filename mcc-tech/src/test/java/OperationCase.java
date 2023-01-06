import cs.matemaster.effective_java.Operation;
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
}
