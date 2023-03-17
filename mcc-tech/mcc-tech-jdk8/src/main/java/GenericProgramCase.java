import java.util.Optional;

/**
 * @author MateMaster
 * @since 2023/3/16
 */
public class GenericProgramCase<E> {

    /**
     *  不允许静态泛型变量及方法
     *  private static E genericStaticVariable;
     */


    /**
     * 错误静态方法
     * public static E getGeneric() {
     * return null;
     * }
     */

    private E elem;

    private static <T extends Comparable<T>> boolean genericStaticMethod(T var1, T var2) {
        return true;
    }

    public void setElem(E elem) {
        this.elem = elem;
    }

    public E getElem() {
        return elem;
    }

    public static void genericMethodAndField() {
        GenericProgramCase<String> programCase = new GenericProgramCase<>();
        programCase.setElem("programming");
        Optional<String> elem = Optional.ofNullable(programCase.getElem());
        elem.ifPresent(System.out::println);
    }
}
