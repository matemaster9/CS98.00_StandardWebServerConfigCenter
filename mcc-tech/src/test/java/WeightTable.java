import cs.matemaster.effective_java.Planet;
import cs.matemaster.standardwebserver.common.util.DataFakerUtil;

/**
 * @author matemaster
 */
public class WeightTable {

    public static void main(String[] args) {
        double earthWeight = DataFakerUtil.localRandom.nextDouble();
        double mass = Math.abs(earthWeight) / Planet.Earth.getSurfaceGravity();

        for (Planet value : Planet.values()) {
            System.out.printf("Weight on  %s is %f%n", value, value.surfaceWeight(mass));
        }
    }
}
