package cs.matemaster.standardwebserver.app.controller;

import cs.matemaster.standardwebserver.app.facade.SchemaFacade;
import cs.matemaster.standardwebserver.common.model.request.GenerateSchemaRequest;
import cs.matemaster.standardwebserver.common.model.request.MockSchemaRequest;
import cs.matemaster.standardwebserver.common.model.request.TableSchemaPagingQuery;
import cs.matemaster.standardwebserver.common.model.response.PageDataView;
import cs.matemaster.standardwebserver.common.model.vo.GenerateSchemaVO;
import cs.matemaster.standardwebserver.common.model.vo.MockSchemaVO;
import cs.matemaster.standardwebserver.common.model.vo.TableSchemaVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author matemaster
 */
@RestController
@RequestMapping("/schema")
@RequiredArgsConstructor
@Tag(name = "SchemaController", description = "模式控制器")
public class SchemaController {

    private final SchemaFacade schemaFacade;

    @Operation(summary = "生成模式")
    @PostMapping("/generate")
    public GenerateSchemaVO generateSchema(@RequestBody GenerateSchemaRequest request) {
        return schemaFacade.generateSchema(request);
    }

    @Operation(summary = "生成模式仿真数据")
    @PostMapping("/mock")
    public MockSchemaVO getMockSchema(@RequestBody MockSchemaRequest request) {
        return schemaFacade.getMockSchema(request);
    }

    @Operation(summary = "分页查询表模式信息")
    @PostMapping("/table/page")
    public PageDataView<List<TableSchemaVO>> pagingTableSchema(@RequestBody TableSchemaPagingQuery query) {
        return null;
    }
}
