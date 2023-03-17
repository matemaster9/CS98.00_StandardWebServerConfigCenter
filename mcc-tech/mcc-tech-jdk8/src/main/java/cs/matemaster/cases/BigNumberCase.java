package cs.matemaster.cases;

import java.math.BigInteger;

/**
 * @author matemaster
 */
public class BigNumberCase {

    public static void power() {
        BigInteger value = BigInteger.valueOf(6);
        System.out.println("6^13: " + value.pow(13));

        BigInteger number = BigInteger.valueOf(93);
        System.out.println("93^17: " + number.pow(17));
    }
}
