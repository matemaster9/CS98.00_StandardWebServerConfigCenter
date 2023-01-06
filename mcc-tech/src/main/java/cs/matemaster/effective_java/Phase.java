package cs.matemaster.effective_java;

/**
 * @author matemaster
 */
public enum Phase {

    Solid,

    Liquid,

    Gas,
    ;

    public enum Transition {
        Melt,

        Freeze,

        Boil,

        Condense,

        Sublime,

        Deposit,
        ;

        private static final Transition[][] transitions = {
                {null, Melt, Sublime},
                {Freeze, null, Boil},
                {Deposit, Condense, null}
        };

        public static Transition from(Phase from, Phase to) {
            return transitions[from.ordinal()][to.ordinal()];
        }
    }
}
