package cs.matemaster.effective_java;

/**
 * @author matemaster
 */
public enum Ensemble {

    Solo,

    Duet,

    Trio,


    Quartet,

    Quintet,

    Sextet,

    Septet,

    Octet,

    Nonet,

    Dectet,

    ;

    public int numberOfMusicians() {
        // 避免使用序数ordinal()， effective Java建议只有在编写EnumSet、EnumMap基于枚举的数据结构时可使用，其他情况应该避免使用
        return ordinal() + 1;
    }
}
