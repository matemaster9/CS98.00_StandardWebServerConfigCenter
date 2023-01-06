package cs.matemaster.effective_java;

/**
 * @author matemaster
 */
public class Text {

    public static final int STYLE_BOLD = 1 << 0;

    public static final int STYLE_ITALIC = 1 << 1;

    public static final int STYLE_UNDERLINE = 1 << 2;

    public static final int STYLE_STRIKETHROUGH = 1 << 3;

    public void applyStyles(int styles) {
        System.out.println(styles);
    }

}
