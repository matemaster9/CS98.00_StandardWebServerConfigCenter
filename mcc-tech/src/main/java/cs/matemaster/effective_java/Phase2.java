package cs.matemaster.effective_java;

import lombok.Getter;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author matemaster
 */
public enum Phase2 {

    Solid,

    Liquid,

    Gas,
    ;

    @Getter
    public enum Transition2 {
        Melt(Solid, Liquid),

        Freeze(Liquid, Solid),

        Boil(Liquid, Gas),

        Condense(Gas, Liquid),

        Sublime(Solid, Gas),

        Deposit(Gas, Solid),
        ;

        private final Phase2 from;
        private final Phase2 to;

        private static final Map<Phase2, Map<Phase2, Transition2>> enumMap;

        Transition2(Phase2 from, Phase2 to) {
            this.from = from;
            this.to = to;
        }

        public static Transition2 from(Phase2 from, Phase2 to) {
            return enumMap.get(from).get(to);
        }


        static {
            enumMap = Stream.of(values()).collect(
                    Collectors.groupingBy(
                            Transition2::getFrom,
                            () -> new EnumMap<>(Phase2.class),
                            Collectors.toMap(Transition2::getTo, t -> t, (x, y) -> y, () -> new EnumMap<>(Phase2.class)))
            );
        }
    }
}
