import com.google.common.collect.Lists;
import cs.matemaster.standardwebserver.common.model.request.GenerateSchemaRequest;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import org.junit.Test;

import java.util.Collections;

/**
 * @author matemaster
 */
public class GenerateSchemaRequestTest {

    @Test
    public void name() {
        GenerateSchemaRequest.Columns columns = new GenerateSchemaRequest.Columns();
        columns.setColumnName("table");
        columns.setComment("列表");
        columns.setDataType("varchar(256)");
        columns.setNotNull(true);
        columns.setDefaultValue("aaaa");
        columns.setAutoIncrement(false);

        GenerateSchemaRequest.Keys keys = new GenerateSchemaRequest.Keys();
        keys.setKeyName("pk");
        keys.setColumns(Collections.singletonList("id"));
        keys.setPrimary(true);

        GenerateSchemaRequest.Indexes indexes = new GenerateSchemaRequest.Indexes();
        indexes.setIndexName("idx");
        indexes.setColumns(Lists.asList("table", new String[]{"kk"}));

        GenerateSchemaRequest generateSchemaRequest = new GenerateSchemaRequest();
        generateSchemaRequest.setDatabaseName("CS98.00_StandardWebServerConfigCenter");
        generateSchemaRequest.setTableName("table_info");
        generateSchemaRequest.setEnablePersist(false);
        generateSchemaRequest.setKeyList(Collections.singletonList(keys));
        generateSchemaRequest.setColumnList(Collections.singletonList(columns));
        generateSchemaRequest.setIndexList(Collections.singletonList(indexes));

        System.out.println(JsonUtil.serialize(generateSchemaRequest));
    }
}
