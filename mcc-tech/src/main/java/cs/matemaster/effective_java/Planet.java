package cs.matemaster.effective_java;

import lombok.Getter;

/**
 * @author matemaster
 */
@Getter
public enum Planet {

    Mercury(3.302e+23, 2.439e6),

    Venus(4.689e+24, 6.052e6),

    Earth(5.975e+24, 6.378e6),

    Mars(6.419e+23, 3.393e6),

    Jupiter(1.899e+27, 7.149e7),

    Saturn(5.685e+26, 6.027e7),

    Uranus(8.683e+25, 2.556e7),

    Neptune(1.024e+26, 2.477e7),
    ;

    private final double mass;

    private final double radius;

    private final double surfaceGravity;

    private static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (Math.pow(radius, 2));
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }
}
