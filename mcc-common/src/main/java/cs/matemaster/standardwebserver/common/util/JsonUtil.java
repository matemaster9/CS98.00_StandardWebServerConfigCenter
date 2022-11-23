package cs.matemaster.standardwebserver.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @author matemaster
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonUtil {

    private static final ObjectMapper defaultMapper = new ObjectMapper();


    public static String serialize(Object arg) {
        try {
            return defaultMapper.writeValueAsString(arg);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }

    public static <T> T deserialize(String jsonString, TypeReference<T> typeReference) {
        try {
            return defaultMapper.readValue(jsonString, typeReference);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }

    public static <T> T deserialize(String jsonString, Class<T> clazz) {
        try {
            return defaultMapper.readValue(jsonString, clazz);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }

    public static String pretty(String jsonString) {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(jsonString);
        return gson.toJson(jsonElement);
    }
}
