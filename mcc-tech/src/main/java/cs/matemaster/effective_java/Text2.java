package cs.matemaster.effective_java;

import java.util.Set;

/**
 * @author matemaster
 */
public class Text2 {

    public void applyStyles(Set<Style> styles) {
        System.out.println(styles);
    }

    public enum Style {
        Bold,

        Italic,

        Underline,

        StrikeThrough,
        ;
    }
}
