import cs.matemaster.effective_java.PayrollDay;
import cs.matemaster.effective_java.PayrollDay2;

/**
 * @author matemaster
 */
public class PayrollDayCase {

    public static void main(String[] args) {
        int pay = PayrollDay.Monday.pay(10, 200);
        System.out.println(pay);

        int pay1 = PayrollDay2.Saturday.pay(10, 200);
        System.out.println(pay1);
    }
}
