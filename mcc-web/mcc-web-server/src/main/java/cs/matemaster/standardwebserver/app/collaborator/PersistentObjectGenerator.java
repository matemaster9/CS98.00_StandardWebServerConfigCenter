package cs.matemaster.standardwebserver.app.collaborator;

import com.google.common.collect.ImmutableMap;
import cs.matemaster.standardwebserver.common.model.dto.PersistentObjectDto;
import cs.matemaster.standardwebserver.common.model.dto.TableSchemaDto;
import cs.matemaster.standardwebserver.common.util.BusinessUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
@Component
@RequiredArgsConstructor
public class PersistentObjectGenerator {

    private final Configuration configuration;

    private static final Map<String, String> FieldTypeMapper;

    @SneakyThrows({IOException.class, TemplateException.class})
    public String getJavaCode(TableSchemaDto tableSchemaDto) {
        String tableName = tableSchemaDto.getTableName();
        String className = BusinessUtil.snakeToUpperCamel(tableName);
        List<TableSchemaDto.Columns> columnList = tableSchemaDto.getColumnList();
        List<PersistentObjectDto.Field> fields = columnList.stream().map(this::convertColumns2Field).collect(Collectors.toList());

        PersistentObjectDto persistentObject = new PersistentObjectDto();
        persistentObject.setClassName(className);
        persistentObject.setFields(fields);

        StringWriter stringWriter = new StringWriter();
        Template template = configuration.getTemplate("JavaCode.ftl");
        template.process(persistentObject, stringWriter);
        return stringWriter.toString();
    }

    private PersistentObjectDto.Field convertColumns2Field(TableSchemaDto.Columns columns) {
        String columnName = columns.getColumnName();
        String fieldName = BusinessUtil.snakeToLowerCamel(columnName);
        String dataType = columns.getDataType();
        String javaType = FieldTypeMapper.getOrDefault(dataType, "Object");
        String comment = Optional.ofNullable(columns.getComment()).orElse(fieldName);

        PersistentObjectDto.Field field = new PersistentObjectDto.Field();
        field.setFieldName(fieldName);
        field.setJavaType(javaType);
        field.setComment(comment);
        return field;
    }

    static {
        String integerJ = "Integer";
        String longJ = "Long";
        String localDateTimeJ = "LocalDateTime";
        String doubleJ = "Double";
        String bigDecimalJ = "BigDecimal";
        String byteArray = "byte[]";
        String stringJ = "String";
        FieldTypeMapper = ImmutableMap.<String, String>builder()
                .put("tinyint", integerJ)
                .put("smallint", integerJ)
                .put("mediumint", integerJ)
                .put("int", integerJ)
                .put("bigint", longJ)
                .put("float", doubleJ)
                .put("double", doubleJ)
                .put("decimal", bigDecimalJ)
                .put("date", localDateTimeJ)
                .put("time", localDateTimeJ)
                .put("year", integerJ)
                .put("datetime", longJ)
                .put("timestamp", localDateTimeJ)
                .put("char", stringJ)
                .put("varchar", stringJ)
                .put("tinytext", stringJ)
                .put("text", stringJ)
                .put("mediumtext", stringJ)
                .put("longtext", stringJ)
                .put("tinyblob", byteArray)
                .put("blob", byteArray)
                .put("mediumblob", byteArray)
                .put("longblob", byteArray)
                .put("binary", byteArray)
                .put("varbinary", byteArray)
                .build();
    }
}
