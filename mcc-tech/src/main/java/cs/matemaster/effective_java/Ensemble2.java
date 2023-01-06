package cs.matemaster.effective_java;

/**
 * @author matemaster
 */
public enum Ensemble2 {

    Solo(1),

    Duet(2),

    Trio(3),


    Quartet(4),

    Quintet(5),

    Sextet(6),

    Septet(7),

    Octet(8),

    Nonet(9),

    Dectet(10),

    TripleQuartet(12),

    ;

    private final int numberOfMusicians;

    Ensemble2(int numberOfMusicians) {
        this.numberOfMusicians = numberOfMusicians;
    }

    public int numberOfMusicians() {
        return numberOfMusicians;
    }
}
