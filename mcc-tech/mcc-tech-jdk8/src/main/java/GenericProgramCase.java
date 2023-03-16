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
     *      return null;
     * }
     */

    public static <T extends Comparable> boolean genericStaticMethod(T var1, T var2) {
        return true;
    }
}
