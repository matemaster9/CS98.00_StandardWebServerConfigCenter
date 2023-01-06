import com.google.common.collect.ImmutableSet;
import cs.matemaster.effective_java.Text;
import cs.matemaster.effective_java.Text2;

import java.util.EnumSet;

/**
 * @author matemaster
 */
public class TextCase {

    public static void main(String[] args) {
        Text text = new Text();
        // 位域
        text.applyStyles(Text.STYLE_BOLD | Text.STYLE_ITALIC);

        Text2 text2 = new Text2();
        // 利用EnumSet替换位域，使用不可变集合包装，包装EnumSet的不可变性
        EnumSet<Text2.Style> styles = EnumSet.of(Text2.Style.Bold, Text2.Style.Italic);
        text2.applyStyles(ImmutableSet.copyOf(styles));
    }
}
