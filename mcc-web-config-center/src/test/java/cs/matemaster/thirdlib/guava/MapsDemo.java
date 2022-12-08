package cs.matemaster.thirdlib.guava;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * @author matemaster
 */
public class MapsDemo {

    @Test
    public void createMap() {
        Map<String, Object> mapping = Maps.newHashMap();
        Map<String, Object> mapping2 = Maps.newHashMapWithExpectedSize(64);
    }
}
