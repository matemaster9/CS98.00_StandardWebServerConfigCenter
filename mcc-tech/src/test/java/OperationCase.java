import cs.matemaster.effective_java.Operation;
import cs.matemaster.standardwebserver.common.util.DataFakerUtil;

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
}
