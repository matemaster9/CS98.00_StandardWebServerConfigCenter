package cs.matemaster.tech.config.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
@ConfigurationPropertiesBinding
public class SystemUserConverter implements Converter<String, SystemUser> {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public SystemUser convert(String json) {
        try {
            return OBJECT_MAPPER.readValue(json, SystemUser.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}