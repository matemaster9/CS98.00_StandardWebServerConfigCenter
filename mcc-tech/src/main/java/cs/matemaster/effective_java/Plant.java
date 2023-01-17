package cs.matemaster.effective_java;

import lombok.Getter;

/**
 * @author matemaster
 */
@Getter
public class Plant {

    private final String name;
    private final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    public enum LifeCycle {
        Annual,

        Perennial,

        Biennial,
        ;
    }

    @Override
    public String toString() {
        return name;
    }
}
