package cs.matemaster.tech.es_client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author matemaster
 */
@Setter
@Getter
@ToString
public class KibanaSampleDataLog {

    private String agent;

    private int bytes;

    @JsonProperty("clientip")
    private String clientIp;

    private String extension;

    private Geo geo;

    private String host;

    private String index;

    private String ip;

    private Machine machine;

    private String memory;

    private String message;

    @JsonProperty("phpmemory")
    private String phpMemory;

    private String referer;

    private String request;

    private int response;

    private List<String> tags;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timestamp;

    private String url;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("utc_time")
    private LocalDateTime utcTime;

    private Event event;

    @Setter
    @Getter
    private static class Geo {
        @JsonProperty("srcdest")
        private String srcDest;
        private String src;
        private String dest;
        private Coordinates coordinates;
    }

    @Setter
    @Getter
    private static class Coordinates {
        private String lat;
        private String lon;
    }

    @Setter
    @Getter
    private static class Machine {
        private long ram;
        private String os;
    }

    @Setter
    @Getter
    private static class Event {
        @JsonProperty("dataset")
        private String dataSet;
    }
}
