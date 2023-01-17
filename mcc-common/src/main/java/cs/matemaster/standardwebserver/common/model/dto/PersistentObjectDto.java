package cs.matemaster.standardwebserver.common.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author matemaster
 */
@Data
public class PersistentObjectDto {

    /**
     * 类名
     */
    private String className;

    private List<Field> fields;

    @Setter
    @Getter
    public static class Field {
        /**
         * 字段类型
         */
        private String javaType;

        /**
         * 字段名称
         */
        private String fieldName;

        /**
         * 注释
         */
        private String comment;
    }
}
