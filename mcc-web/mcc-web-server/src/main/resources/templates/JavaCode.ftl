import lombok.Data;


@Data
public class ${className} {
    <#list fields as field>
        <#if field.comment!?length gt 0>
            /**
             * ${field.comment}
             */
        </#if>
        private ${field.javaType} ${field.fieldName};
    </#list>
}