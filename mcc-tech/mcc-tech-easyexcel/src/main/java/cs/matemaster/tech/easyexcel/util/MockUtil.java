package cs.matemaster.tech.easyexcel.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author matemaster
 */
public class MockUtil {

    private static final String ALPHABET_NUMBER = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static ThreadLocalRandom random = ThreadLocalRandom.current();

    /**
     * 生成指定前缀的唯一id prefix + 创建时时间戳 + 8位随机字符
     *
     * @param prefix
     * @return
     */
    public static String getUniqueId(String prefix) {
        return prefix + System.currentTimeMillis() + getRandomString(8);
    }

    public static String getRandomString(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(ALPHABET_NUMBER.charAt(random.nextInt(0, ALPHABET_NUMBER.length())));
        }
        return builder.toString();
    }
}
