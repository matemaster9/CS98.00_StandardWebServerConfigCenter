package cs.matemaster.standardwebserver.controller;

import cs.matemaster.standardwebserver.common.model.dto.storage_management.BookStorageDetailDto;
import cs.matemaster.standardwebserver.common.model.request.BookStorageDetailPagingQuery;
import cs.matemaster.standardwebserver.common.model.response.PageDataView;
import cs.matemaster.standardwebserver.service.StorageManagementService;
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
@RequestMapping("/storage-management")
@RequiredArgsConstructor
@Tag(name = "StorageManagementController", description = "库存管理控制器")
public class StorageManagementController {

    private final StorageManagementService storageManagementService;

    @PostMapping("/save")
    @Operation(summary = "保存库存明细信息")
    public Boolean saveStorageDetailInfo(@RequestBody BookStorageDetailDto request) {
        return storageManagementService.saveStorageDetail(request) == 1;
    }

    @PostMapping("/batch-save")
    @Operation(summary = "保存库存明细信息")
    public Boolean batchSaveStorageDetailInfo(@RequestBody List<BookStorageDetailDto> request) {
        return storageManagementService.batchSaveStorageDetail(request) != 0;
    }

    @PostMapping("/paging-query-book-storage-detail")
    @Operation(summary = "分页查询库存明细信息")
    public PageDataView<List<BookStorageDetailDto>> pagingQueryBookStorageDetail(@RequestBody BookStorageDetailPagingQuery query) {
        return null;
    }
}
