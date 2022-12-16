package cs.matemaster.effective_java;

import java.util.Collection;

/**
 * @author matemaster
 */
public interface IStack<E> {

    void push(E e);

    E pop();

    boolean isEmpty();

    void pushAll(Iterable<? extends E> src);

    void popAll(Collection<? super E> dst);
}
